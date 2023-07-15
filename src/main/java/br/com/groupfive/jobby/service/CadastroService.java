package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.repository.CadastroRepository;
import br.com.groupfive.jobby.service.interfaces.ICadastroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService implements ICadastroService<Integer> {

    @Autowired
    CadastroRepository cadastroRepository;

    @Override
    public CadastroDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<CadastroDTO> findByHabilidade(String habilidade) {
        return null;
    }

    @Override
    public CadastroDTO create(CreateCadastroDTO createCadastroDTO) {
        Cadastro cadastroModel = new Cadastro();

        BeanUtils.copyProperties(createCadastroDTO, cadastroModel);
        System.out.println(cadastroModel.toString());
        //cadastroRepository.save(cadastroModel);

        return CadastroDTO.fromModel(cadastroModel);
    }

    @Override
    public boolean update(UpdateCadastroDTO updateCadastroDTO, Integer id) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
