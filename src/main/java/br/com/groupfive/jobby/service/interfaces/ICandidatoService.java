package br.com.groupfive.jobby.service.interfaces;

import br.com.groupfive.jobby.dto.candidato.CandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.CreateCandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.UpdateCandidatoDTO;

public interface ICandidatoService<T> {
    CandidatoDTO findById(T id);
    CandidatoDTO findByName(String name);
    CandidatoDTO create(CreateCandidatoDTO createCandidatoDTO);
    boolean update(UpdateCandidatoDTO updateCandidatoDTO);
    boolean deleteById(T id);
}
