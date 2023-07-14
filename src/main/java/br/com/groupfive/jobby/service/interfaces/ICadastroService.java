package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;

import java.util.List;

public interface ICadastroService<T> {
    CadastroDTO findById(T id);
    List<CadastroDTO> findByHabilidade(String habilidade);
    CadastroDTO create(CreateCadastroDTO createCadastroDTO);
    boolean update(UpdateCadastroDTO updateCadastroDTO, Integer id);
    boolean deleteById(T id);
}
