package com.lucasricardo1.CrudExemplo.mappers;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.dtos.ProfissionalDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface ProfissionalMapper {
    ProfissionalMapper INSTANCE = Mappers.getMapper(ProfissionalMapper.class);

    ProfissionalEntity toEntity(ProfissionalDTO dto);

    ProfissionalDTO toDto(ProfissionalEntity entity);

    List<ProfissionalDTO> toDtos(List<ProfissionalEntity> entities);
}