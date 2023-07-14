package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;
import br.com.groupfive.jobby.service.interfaces.IEnderecoService;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService<Integer> {

    @Override
    public EnderecoDTO findById(Integer id) {
        return null;
    }

    @Override
    public EnderecoDTO findByName(String name) {
        return null;
    }

    @Override
    public EnderecoDTO create(CreateEnderecoDTO createEnderecoDTO) {
        return null;
    }

    @Override
    public boolean update(UpdateEnderecoDTO updateEnderecoDTO) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
