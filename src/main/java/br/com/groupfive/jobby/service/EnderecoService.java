package br.com.groupfive.jobby.service;

import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;
import br.com.groupfive.jobby.model.Cidade;
import br.com.groupfive.jobby.model.Endereco;
import br.com.groupfive.jobby.repository.CidadeRepository;
import br.com.groupfive.jobby.repository.EnderecoRepository;
import br.com.groupfive.jobby.service.interfaces.IEnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService implements IEnderecoService<Integer> {

    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    CidadeRepository cidadeRepository;
    @Override
    public EnderecoDTO findById(Integer id) {
        if(enderecoRepository.existsById(id)){
            Endereco enderecoModel = enderecoRepository.findById(id).get();
            return EnderecoDTO.fromModel(enderecoModel);
        }else{
            return null;
        }
    }

    @Override
    public EnderecoDTO create(CreateEnderecoDTO createEnderecoDTO) {
        Endereco enderecoModel = new Endereco();
        BeanUtils.copyProperties(createEnderecoDTO, enderecoModel);
        enderecoModel.setCidade(cidadeRepository.findById(createEnderecoDTO.idCidade()).get());
        enderecoRepository.save(enderecoModel);
        return EnderecoDTO.fromModel(enderecoModel);
    }

    @Override
    public boolean update(UpdateEnderecoDTO updateEnderecoDTO, Integer id) {
        if(enderecoRepository.existsById(id)){
            Endereco enderecoModel = enderecoRepository.findById(id).get();
            BeanUtils.copyProperties(updateEnderecoDTO, enderecoModel);
            enderecoModel.setCidade(cidadeRepository.findById(updateEnderecoDTO.idCidade()).get());
            enderecoRepository.save(enderecoModel);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        if(enderecoRepository.existsById(id)){
            enderecoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
