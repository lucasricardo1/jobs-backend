package com.lucasricardo1.CrudExemplo.services;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import com.lucasricardo1.CrudExemplo.mappers.ContatoMapper;
import com.lucasricardo1.CrudExemplo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

     public ContatoEntity saveContact(ContatoDTO contatoDTO){
         return contatoRepository.save(ContatoMapper.INSTANCE.toEntity(contatoDTO));
     }

     public List<ContatoEntity> saveContacts(List<ContatoDTO> contatos){
        return contatoRepository.saveAll(ContatoMapper.INSTANCE.toEntities(contatos));
    }
}
