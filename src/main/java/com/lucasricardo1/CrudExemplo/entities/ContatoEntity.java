package entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Contato")
@Data
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
