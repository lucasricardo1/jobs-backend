package com.lucasricardo1.CrudExemplo.entities;

import com.lucasricardo1.CrudExemplo.enums.Cargo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profissional")
public class ProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    private LocalDate nascimento;

    private LocalDate createData;


}
