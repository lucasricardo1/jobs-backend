package com.lucasricardo1.CrudExemplo.mappers;

import com.lucasricardo1.CrudExemplo.dtos.ProfissionalDTO;
import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfissionalMapper {
    ProfissionalMapper INSTANCE = Mappers.getMapper(ProfissionalMapper.class);

    ProfissionalEntity toEntity(ProfissionalDTO dto);

    ProfissionalDTO toDto(ProfissionalEntity entity);
}