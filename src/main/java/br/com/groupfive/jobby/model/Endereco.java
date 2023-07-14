package br.com.groupfive.jobby.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    private Long cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;
}
