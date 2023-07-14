package br.com.groupfive.jobby.dto.candidato;

import java.time.LocalDate;

public record CandidatoDTO (
    String nome,
    String cpf,
    String sexo,
    LocalDate dataNascimento,
    Integer telefone,
    String email
) {}
