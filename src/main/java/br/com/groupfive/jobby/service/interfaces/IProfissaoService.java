package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.profissao.CreateProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.UpdateProfissaoDTO;

public interface IProfissaoService<T> {
    ProfissaoDTO findById(T id);

    ProfissaoDTO create(CreateProfissaoDTO createProfissaoDTO);

    boolean update(UpdateProfissaoDTO updateProfissaoDTO, T id);

    boolean deleteById(T id);
}
