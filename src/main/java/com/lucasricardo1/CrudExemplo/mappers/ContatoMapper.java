package com.lucasricardo1.CrudExemplo.mappers;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContatoMapper {
    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    @Mapping(target = "profissionalEntity", ignore = true)
    ContatoEntity toEntity(ContatoDTO dto);

    @Mapping(target = "profissionalEntity", ignore = true)
    List<ContatoEntity> toEntities(List<ContatoDTO> dtos);

    ContatoDTO toDto(ContatoEntity entity);


}