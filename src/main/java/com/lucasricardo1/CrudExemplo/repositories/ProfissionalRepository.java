package com.lucasricardo1.CrudExemplo.repositories;

import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {
}
