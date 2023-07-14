package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.candidato.CandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.CreateCandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.UpdateCandidatoDTO;
import org.springframework.http.ResponseEntity;

public interface ICandidatoController<T> {
    ResponseEntity<CandidatoDTO> findById(T id);
    ResponseEntity<CandidatoDTO> findByName(String name);
    ResponseEntity<CandidatoDTO> create(CreateCandidatoDTO createCandidatoDTO);
    ResponseEntity update(UpdateCandidatoDTO updateCandidatoDTO, T id);
    ResponseEntity deleteById(T id);
}
