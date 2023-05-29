package com.lucasricardo1.CrudExemplo.repositories;

import com.lucasricardo1.CrudExemplo.entities.ProfissionalEntity;
import com.lucasricardo1.CrudExemplo.enums.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {

    @Query(value = "SELECT * FROM Profissional p WHERE " +
            ":busca IS NULL OR " +
            "p.nome LIKE %:busca% OR " +
            "p.cargo LIKE %:busca% ", nativeQuery = true)
    List<ProfissionalEntity> findProfissionaisByParam(String busca);

}
