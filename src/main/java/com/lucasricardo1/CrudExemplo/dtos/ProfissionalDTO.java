package com.lucasricardo1.CrudExemplo.dtos;

import com.lucasricardo1.CrudExemplo.enums.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalDTO {

    private Long id;
    private String nome;
    private Cargo cargo;
    private LocalDate nascimento;
    private LocalDate createData;
    private List<ContatoDTO> contatos;

}
