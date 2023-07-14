package br.com.groupfive.jobby.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;



@Entity
@Table(name = "tb_empresa")
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Column(length = 60, nullable = false)
    private String nome;

}