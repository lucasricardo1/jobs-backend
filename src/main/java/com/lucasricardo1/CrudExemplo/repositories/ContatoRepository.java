package com.lucasricardo1.CrudExemplo.repositories;

import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
}
