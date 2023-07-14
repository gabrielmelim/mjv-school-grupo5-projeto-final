package br.com.groupfive.jobby.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PretencaoSalarial {
    @Column(name = "vl_min",nullable = false)
    private Double valorMinimo;
    @Column(name = "vl_max",nullable = false)
    private Double valorMaximo;
}


