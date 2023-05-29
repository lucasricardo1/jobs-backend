package com.lucasricardo1.CrudExemplo.mappers;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface ContatoMapper {
    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    ContatoEntity toEntity(ContatoDTO dto);

    @Mapping(target = "profissionalId", ignore = true)
    ContatoDTO toDto(ContatoEntity entity);

    @Mapping(target = "profissionalId", ignore = true)
    List<ContatoDTO> toDtos(List<ContatoEntity> entities);


}