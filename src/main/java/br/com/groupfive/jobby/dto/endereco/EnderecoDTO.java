package br.com.groupfive.jobby.dto.endereco;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.model.Cidade;
import br.com.groupfive.jobby.model.Endereco;

public record EnderecoDTO(
    Long cep,
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    CidadeDTO cidade
)
{
    public static EnderecoDTO fromModel(Endereco endereco, Cidade cidade) {
        return new EnderecoDTO(
            endereco.getCep(),
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getBairro(),
            CidadeDTO.fromModel(cidade)
        );
    }
}
