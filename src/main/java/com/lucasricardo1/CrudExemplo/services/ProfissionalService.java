package com.lucasricardo1.CrudExemplo.services;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.dtos.ProfissionalDTO;
import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import com.lucasricardo1.CrudExemplo.mappers.ProfissionalMapper;
import com.lucasricardo1.CrudExemplo.repositories.ContatoRepository;
import com.lucasricardo1.CrudExemplo.repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private  ContatoRepository contatoRepository;

    @Autowired
    private  ContatoService contatoService;

    public List<ProfissionalEntity> buscarProfissional(String q){
        return profissionalRepository.findProfissionaisByParam(q);
    }

    public ProfissionalEntity buscarProfissionalPorId(Long id){
        Optional<ProfissionalEntity> profissionalEntity = profissionalRepository.findById(id);
        if(profissionalEntity.isPresent())
            return profissionalEntity.get();
        else return null;
    }

    public ProfissionalEntity salvarProfissional(ProfissionalDTO profissionalDTO){
        ProfissionalEntity profissionalEntity =
                profissionalRepository.save(ProfissionalMapper.INSTANCE.toEntity(profissionalDTO));

        Long profissionalId = profissionalEntity.getId();

        if(profissionalDTO.getContatos() != null && profissionalDTO.getContatos().size() > 0) {
            for (ContatoDTO contatoDTO : profissionalDTO.getContatos()) {
                contatoDTO.setProfissionalId(profissionalId);
                contatoService.salvarContato(contatoDTO);
            }
        }
        return profissionalEntity;
    }

    public ProfissionalEntity atualizarProfissional(ProfissionalDTO profissionalDTO){
        ProfissionalEntity profissionalEntity = profissionalRepository.findById(profissionalDTO.getId()).get();
        profissionalEntity.setNome(profissionalDTO.getNome());
        profissionalEntity.setCargo(profissionalDTO.getCargo());
        profissionalEntity.setNascimento(profissionalDTO.getNascimento());
        profissionalEntity.setCreateData(profissionalDTO.getCreateData());

        if(profissionalDTO.getContatos() != null && profissionalDTO.getContatos().size() > 0){
            for(ContatoDTO contatoDTO : profissionalDTO.getContatos()){
                contatoService.atualizarContato(contatoDTO);
            }
        }

        return profissionalRepository.save(profissionalEntity);
    }

    public void deletarProfissional(Long id){
        profissionalRepository.deleteById(id);
    }
}
