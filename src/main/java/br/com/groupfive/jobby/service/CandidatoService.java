package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.candidato.CandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.CreateCandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.UpdateCandidatoDTO;
import br.com.groupfive.jobby.service.interfaces.ICandidatoService;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService<T> implements ICandidatoService<Integer> {
    @Override
    public CandidatoDTO findById(Integer id) {
        return null;
    }

    @Override
    public CandidatoDTO findByName(String name) {
        return null;
    }

    @Override
    public CandidatoDTO create(CreateCandidatoDTO createCandidatoDTO) {
        return null;
    }

    @Override
    public boolean update(UpdateCandidatoDTO updateCandidatoDTO) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
