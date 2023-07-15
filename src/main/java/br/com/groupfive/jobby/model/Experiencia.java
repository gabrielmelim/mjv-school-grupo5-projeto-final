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
public class Experiencia {
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

    @Column(name = "nome_empresa",length = 60, nullable = false)
    private String nomeEmpresa;

    @Enumerated(EnumType.STRING)
    @Column(name = "regime_contrat",nullable = false)
    private RegimeContratacao regimeContratacao;

    @ManyToOne
    @JoinColumn(name = "id_cadastro")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

}
