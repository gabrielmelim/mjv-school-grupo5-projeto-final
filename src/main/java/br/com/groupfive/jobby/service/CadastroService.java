package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;
import br.com.groupfive.jobby.mapper.CadastroMapper;
import br.com.groupfive.jobby.model.Cadastro;
import br.com.groupfive.jobby.repository.CadastroRepository;
import br.com.groupfive.jobby.repository.EnderecoRepository;
import br.com.groupfive.jobby.repository.ProfissaoRepository;
import br.com.groupfive.jobby.service.interfaces.ICadastroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService implements ICadastroService<Integer> {

    @Autowired
    CadastroRepository cadastroRepository;
    @Autowired
    ProfissaoRepository profissaoRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public CadastroDTO findById(Integer id) {
        if(cadastroRepository.existsById(id)){
            Cadastro cadastroModel = cadastroRepository.findById(id).get();
            return CadastroDTO.fromModel(cadastroModel);
        }else{
            return null;
        }
    }

    @Override
    public List<CadastroDTO> findByHabilidade(String habilidade) {
        return null;
    }

    @Override
    public CadastroDTO create(CreateCadastroDTO createCadastroDTO) {
        Cadastro cadastroModel = CadastroMapper
                .fromCreateCadastroDTOToEntity(createCadastroDTO,
                enderecoRepository.findById(createCadastroDTO.idEndereco()).get(),
                profissaoRepository.findById(createCadastroDTO.idProfissao()).get());

        cadastroRepository.save(cadastroModel);

        return CadastroDTO.fromModel(cadastroModel);
    }

    @Override
    public boolean update(UpdateCadastroDTO updateCadastroDTO, Integer id) {
        if(cadastroRepository.existsById(id)){
            Cadastro cadastroModel = CadastroMapper
                .fromUpdateCadastroDTOToEntity(updateCadastroDTO,
                enderecoRepository.findById(updateCadastroDTO.idEndereco()).get(),
                profissaoRepository.findById(updateCadastroDTO.idProfissao()).get());

            cadastroRepository.save(cadastroModel);
            return true;

        }else{
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        if(cadastroRepository.existsById(id)){
            cadastroRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
