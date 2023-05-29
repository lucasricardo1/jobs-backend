package com.lucasricardo1.CrudExemplo.services;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import com.lucasricardo1.CrudExemplo.mappers.ContatoMapper;
import com.lucasricardo1.CrudExemplo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private  ContatoRepository contatoRepository;

    public List<ContatoEntity> buscarContatos(String q){
        return contatoRepository.findContatosByParam(q);
    }

    public ContatoEntity buscarContatoPorId(Long id){
        Optional<ContatoEntity> profissionalEntity = contatoRepository.findById(id);
        if(profissionalEntity.isPresent())
            return profissionalEntity.get();
        else return null;
    }

     public ContatoEntity salvarContato(ContatoDTO contatoDTO){
         return contatoRepository.save(ContatoMapper.INSTANCE.toEntity(contatoDTO));
     }

    public ContatoEntity atualizarContato(ContatoDTO contatoDTO){
        ContatoEntity contatoEntity = contatoRepository.findById(contatoDTO.getId()).get();
        contatoEntity.setNome(contatoDTO.getNome());
        contatoEntity.setContato(contatoDTO.getContato());

        return contatoRepository.save(contatoEntity);
    }

    public void deletarContato(Long id){
         contatoRepository.deleteById(id);
    }
}
