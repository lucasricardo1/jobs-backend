package com.lucasricardo1.CrudExemplo.services;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.dtos.ProfissionalDTO;
import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import com.lucasricardo1.CrudExemplo.enums.Cargo;
import com.lucasricardo1.CrudExemplo.repositories.ContatoRepository;
import com.lucasricardo1.CrudExemplo.repositories.ProfissionalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProfissionalServiceTest {

    @Mock
    private ProfissionalRepository profissionalRepository;

    @Mock
    private ContatoRepository contatoRepository;

    @Mock
    private ContatoService contatoService;

    @InjectMocks
    private ProfissionalService profissionalService;

    private final LocalDate DATA_GENERICA = LocalDate.of(1990, 10, 10);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarProfissionalPorId_ProfissionalExistente_DeveRetornarProfissional() {
        Long id = 1L;
        ProfissionalEntity profissional = new ProfissionalEntity(id, "Profissional", Cargo.DESENVOLVEDOR, DATA_GENERICA, LocalDate.now());

        when(profissionalRepository.findById(id)).thenReturn(Optional.of(profissional));

        ProfissionalEntity resultado = profissionalService.buscarProfissionalPorId(id);

        assertEquals(profissional, resultado);
        verify(profissionalRepository, times(1)).findById(id);
    }

    @Test
    void buscarProfissionalPorId_ProfissionalNaoExistente_DeveRetornarNull() {
        Long id = 1L;

        when(profissionalRepository.findById(id)).thenReturn(Optional.empty());

        ProfissionalEntity resultado = profissionalService.buscarProfissionalPorId(id);

        assertEquals(null, resultado);
        verify(profissionalRepository, times(1)).findById(id);
    }

    @Test
    void salvarProfissional_DeveRetornarProfissionalSalvo() {
        ProfissionalDTO profissionalDTO = new ProfissionalDTO(null, "Profissional", Cargo.SUPORTE, DATA_GENERICA, LocalDate.now(), null);
        ProfissionalEntity profissionalSalvo = new ProfissionalEntity(1L, "Profissional", Cargo.SUPORTE, DATA_GENERICA, LocalDate.now());

        when(profissionalRepository.save(any(ProfissionalEntity.class))).thenReturn(profissionalSalvo);

        ProfissionalEntity resultado = profissionalService.salvarProfissional(profissionalDTO);

        assertEquals(profissionalSalvo, resultado);
        verify(profissionalRepository, times(1)).save(any(ProfissionalEntity.class));
    }

    @Test
    void buscarProfissional_DeveRetornarProfissionaisEncontrados() {
        String q = "Lucas";
        List<ProfissionalEntity> profissionais = Arrays.asList(
                new ProfissionalEntity(1L, "Lucas", Cargo.DESENVOLVEDOR, DATA_GENERICA, LocalDate.now()),
                new ProfissionalEntity(2L, "Lucas", Cargo.SUPORTE, DATA_GENERICA, LocalDate.now())
        );

        when(profissionalRepository.findProfissionaisByParam(q)).thenReturn(profissionais);

        List<ProfissionalEntity> resultado = profissionalService.buscarProfissional(q);

        assertEquals(profissionais, resultado);
        verify(profissionalRepository, times(1)).findProfissionaisByParam(q);
    }

    @Test
    void atualizarProfissional_DeveRetornarProfissionalAtualizado() {
        Long id = 1L;
        String nome = "Lucas";
        LocalDate nascimento = LocalDate.of(1990, 1, 1);
        LocalDate createData = LocalDate.now();
        List<ContatoDTO> contatos = Arrays.asList(
                new ContatoDTO(1L, "E-mail", "lucas@example.com", null),
                new ContatoDTO(2L, "Telefone", "123456789", null)
        );

        ProfissionalDTO profissionalDTO = new ProfissionalDTO(id, nome, Cargo.DESENVOLVEDOR, nascimento, createData, contatos);
        ProfissionalEntity profissionalEntity = new ProfissionalEntity(id, nome, Cargo.DESENVOLVEDOR, nascimento, createData);

        when(profissionalRepository.findById(id)).thenReturn(Optional.of(profissionalEntity));
        when(profissionalRepository.save(profissionalEntity)).thenReturn(profissionalEntity);

        ProfissionalEntity resultado = profissionalService.atualizarProfissional(profissionalDTO);

        assertEquals(profissionalEntity, resultado);
        verify(profissionalRepository, times(1)).findById(id);
        verify(profissionalRepository, times(1)).save(profissionalEntity);
        verify(contatoService, times(contatos.size())).atualizarContato(any(ContatoDTO.class));
    }

    @Test
    void deletarProfissional_DeveChamarMetodoDeletarDoRepository() {
        Long id = 1L;

        profissionalService.deletarProfissional(id);

        verify(profissionalRepository, times(1)).deleteById(id);
    }
}