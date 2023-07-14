package br.com.groupfive.jobby.dto.endereco;

import br.com.groupfive.jobby.model.Endereco;

public record EnderecoDTO(
    Integer id,
    Long cep,
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    Integer idCidade
)
{
    public static EnderecoDTO fromModel(Endereco endereco) {
        return new EnderecoDTO(
            endereco.getIdEndereco(),
            endereco.getCep(),
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getBairro(),
            endereco.getCidade().getIdCidade()
        );
    }
}
