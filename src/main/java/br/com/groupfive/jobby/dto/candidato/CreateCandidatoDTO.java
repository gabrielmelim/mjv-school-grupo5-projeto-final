package br.com.groupfive.jobby.dto.candidato;

import java.time.LocalDate;

public record CreateCandidatoDTO (
    String nome,
    String cpf,
    String sexo,
    LocalDate dataNascimento,
    Integer telefone,
    String email,
    Long numeroCelular,
    String isWhats,
    Double pretensaoMin,
    Double pretensaoMax,
    Integer idProfissao,
    Integer idEndereco
) {}
