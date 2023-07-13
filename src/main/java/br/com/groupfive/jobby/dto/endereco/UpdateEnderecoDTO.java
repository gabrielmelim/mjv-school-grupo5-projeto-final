package br.com.groupfive.jobby.dto.endereco;

public record UpdateEnderecoDTO(
    String cep,
    String logradouro,
    String numero,
    String complemento,
    String bairro
) {}
