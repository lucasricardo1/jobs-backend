package com.lucasricardo1.CrudExemplo.repositories;

import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
}
