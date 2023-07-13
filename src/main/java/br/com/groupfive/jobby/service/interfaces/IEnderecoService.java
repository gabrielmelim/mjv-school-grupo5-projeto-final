package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;

public interface IEnderecoService<T> {
    EnderecoDTO findById(T id);
    EnderecoDTO findByName(String name);
    EnderecoDTO create(CreateEnderecoDTO createEnderecoDTO);
    boolean update(UpdateEnderecoDTO updateEnderecoDTO);
    boolean deleteById(T id);
}
