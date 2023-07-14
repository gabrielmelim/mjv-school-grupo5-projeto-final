package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.experiencia.CreateExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.ExperienciaDTO;
import br.com.groupfive.jobby.dto.experiencia.UpdateExperienciaDTO;
import br.com.groupfive.jobby.service.interfaces.IExperienciaService;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService<Integer> {
    @Override
    public ExperienciaDTO findById(Integer id) {
        return null;
    }

    @Override
    public ExperienciaDTO create(CreateExperienciaDTO createExperienciaDTO) {
        return null;
    }

    @Override
    public boolean update(UpdateExperienciaDTO updateExperienciaDTO, Integer id) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
