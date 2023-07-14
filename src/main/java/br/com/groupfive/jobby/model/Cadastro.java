package br.com.groupfive.jobby.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tb_cadastro")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_cadastro")
    private Integer idCadastro;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_nasc",nullable = false, length = 11)
    private Date dataNascimento;

    @Column(nullable = false, length = 11)
    private Long telefone;

    @Column(nullable = false, length = 60)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo",nullable = false)
    private Sexo sexo;

    @Embedded
    private PretencaoSalarial pretencaoSalarial;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="numero",
                     column = @Column(name="cel_num_pess")),
            @AttributeOverride(name="whatsapp",
                    column = @Column(name="cel_is_whats_pess"))
    })
    private Celular celularPessoal;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="numero",
                    column = @Column(name="cel_num_prof")),
            @AttributeOverride(name="whatsapp",
                    column = @Column(name="cel_is_whats_prof"))
    })
    private Celular celularProfissional;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

    @CollectionTable(name="tab_cad_habilidade",
            joinColumns=@JoinColumn(name = "cad_id", referencedColumnName = "id_cadastro"))
    @Column(name="nm_habil")
    @ElementCollection
    private List<String> habilidades;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_endereco")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(name = "regime_contrat",nullable = false)
    private RegimeContratacao regimeContratacao;
}

