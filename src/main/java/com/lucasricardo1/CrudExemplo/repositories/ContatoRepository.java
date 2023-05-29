package com.lucasricardo1.CrudExemplo.repositories;

import com.lucasricardo1.CrudExemplo.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {

    @Query(value = "SELECT * FROM Contato c WHERE " +
            ":busca IS NULL OR " +
            "c.nome LIKE %:busca% OR " +
            "c.contato LIKE %:busca%", nativeQuery = true)
    List<ContatoEntity> findContatosByParam(String busca);

}
