package com.lucasricardo1.CrudExemplo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private Long id;
    private String nome;
    private String contato;

}
