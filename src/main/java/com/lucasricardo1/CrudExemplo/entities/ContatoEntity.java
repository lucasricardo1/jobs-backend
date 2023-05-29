package com.lucasricardo1.CrudExemplo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contato")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String contato;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalEntity profissionalEntity;

}
