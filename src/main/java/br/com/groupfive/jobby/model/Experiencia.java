package br.com.groupfive.jobby.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_cadastro_experiencia")
@Data
public class CadastroExperiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_cad_experiencia")
    private Integer idCadExperiencia;


    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal salario;

    @Column(name = "emprego_atual",nullable = false)
    private boolean empregoAtual;

    @Column(name = "data_contratacao",nullable = false)
    private Date dataContratacao;

    @Column(name = "data_desligamento",nullable = false)
    private Date dataDesligamento;

    @ManyToOne
    @JoinColumn(name = "id_cadastro")
    private Cadastro cadastro;

    @Embedded
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

}
