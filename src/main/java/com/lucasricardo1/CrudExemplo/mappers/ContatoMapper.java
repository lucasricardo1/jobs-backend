package com.lucasricardo1.CrudExemplo.mappers;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {
    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    @Mapping(target = "profissional", ignore = true)
    ContatoEntity toEntity(ContatoDTO dto);

    ContatoDTO toDto(ContatoEntity entity);
}