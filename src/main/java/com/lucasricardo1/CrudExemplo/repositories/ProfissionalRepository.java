package com.lucasricardo1.CrudExemplo.repositories;

import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {
}
