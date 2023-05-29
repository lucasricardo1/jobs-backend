package com.lucasricardo1.CrudExemplo.services;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import com.lucasricardo1.CrudExemplo.repositories.ContatoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ContatoServiceTest {

    @InjectMocks
    private ContatoService contatoService;

    @Mock
    private ContatoRepository contatoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarContatos_DeveRetornarContatosEncontrados() {
        String q = "Lucas";
        List<ContatoEntity> contatos = Arrays.asList(
                new ContatoEntity(1L, "Lucas", "lucas@example.com", null),
                new ContatoEntity(2L, "Lucas", "123456789", null)
        );

        when(contatoRepository.findContatosByParam(q)).thenReturn(contatos);

        List<ContatoEntity> resultado = contatoService.buscarContatos(q);

        assertEquals(contatos, resultado);
        verify(contatoRepository, times(1)).findContatosByParam(q);
    }

    @Test
    void buscarContatoPorId_DeveRetornarContatoExistente() {
        Long id = 1L;
        ContatoEntity contato = new ContatoEntity(id, "Lucas", "lucas@example.com", null);

        when(contatoRepository.findById(id)).thenReturn(Optional.of(contato));

        ContatoEntity resultado = contatoService.buscarContatoPorId(id);

        assertEquals(contato, resultado);
        verify(contatoRepository, times(1)).findById(id);
    }

    @Test
    void buscarContatoPorId_DeveRetornarNullQuandoContatoNaoExistir() {
        Long id = 1L;

        when(contatoRepository.findById(id)).thenReturn(Optional.empty());

        ContatoEntity resultado = contatoService.buscarContatoPorId(id);

        assertNull(resultado);
        verify(contatoRepository, times(1)).findById(id);
    }

    @Test
    void salvarContato_DeveRetornarContatoSalvo() {
        Long id = 1L;
        String nome = "Lucas";
        String contato = "lucas@example.com";
        ContatoDTO contatoDTO = new ContatoDTO(id, nome, contato, null);
        ContatoEntity contatoEntity = new ContatoEntity(id, nome, contato, null);

        when(contatoRepository.save(contatoEntity)).thenReturn(contatoEntity);

        ContatoEntity resultado = contatoService.salvarContato(contatoDTO);

        assertEquals(contatoEntity, resultado);
        verify(contatoRepository, times(1)).save(contatoEntity);
    }

    @Test
    void atualizarContato_DeveRetornarContatoAtualizado() {
        Long id = 1L;
        String nome = "Lucas";
        String contato = "lucas@example.com";
        ContatoDTO contatoDTO = new ContatoDTO(id, nome, contato, null);
        ContatoEntity contatoEntity = new ContatoEntity(id, "Antonio", "antonio@example.com", null);

        when(contatoRepository.findById(id)).thenReturn(Optional.of(contatoEntity));
        when(contatoRepository.save(contatoEntity)).thenReturn(contatoEntity);

        ContatoEntity resultado = contatoService.atualizarContato(contatoDTO);

        assertEquals(contatoEntity, resultado);
        assertEquals(nome, contatoEntity.getNome());
        assertEquals(contato, contatoEntity.getContato());
        verify(contatoRepository, times(1)).findById(id);
        verify(contatoRepository, times(1)).save(contatoEntity);
    }

    @Test
    void deletarContato_DeveChamarMetodoDeleteByIdDoRepository() {
        Long id = 1L;

        contatoService.deletarContato(id);

        verify(contatoRepository, times(1)).deleteById(id);
    }
}

