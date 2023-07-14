package br.com.groupfive.jobby.dto.endereco;

public record CreateEnderecoDTO (
    String cep,
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    Integer idCliente,
    Integer idCidade
) {}
