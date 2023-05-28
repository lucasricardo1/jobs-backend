package entities;

import enums.Cargo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Profissional")
public class ProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    private LocalDate nascimento;

    private LocalDate createData;

    @OneToMany(mappedBy = "profissionalEntity", cascade = CascadeType.ALL)
    private List<ContatoEntity> contatos;

}
