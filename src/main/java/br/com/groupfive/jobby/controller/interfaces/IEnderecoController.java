package br.com.groupfive.jobby.controller.interfaces;

import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;
import org.springframework.http.ResponseEntity;

public interface IEnderecoController<T> {
    ResponseEntity<EnderecoDTO> findById(T id);
    ResponseEntity<EnderecoDTO> findByName(String name);
    ResponseEntity<EnderecoDTO> create(CreateEnderecoDTO createEnderecoDTO);
    ResponseEntity update(UpdateEnderecoDTO updateEnderecoDTO);
    ResponseEntity deleteById(T id);
}
