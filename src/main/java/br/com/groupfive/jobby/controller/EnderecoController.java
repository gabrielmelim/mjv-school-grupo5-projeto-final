package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.IEnderecoController;
import br.com.groupfive.jobby.dto.endereco.CreateEnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.EnderecoDTO;
import br.com.groupfive.jobby.dto.endereco.UpdateEnderecoDTO;
import br.com.groupfive.jobby.service.interfaces.IEnderecoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("endereco")
public class EnderecoController implements IEnderecoController<Integer> {

    private final IEnderecoService<Integer> service;

    public EnderecoController(IEnderecoService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping(params = "id")
    public ResponseEntity<EnderecoDTO> findById(@PathParam("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @GetMapping(params = "name")
    public ResponseEntity<EnderecoDTO> findByName(String name) {
        var dto = service.findByName(name);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@RequestBody CreateEnderecoDTO createEnderecoDTO) {
        var dto = service.create(createEnderecoDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }

    @Override
    @PutMapping
    public ResponseEntity update(@RequestBody UpdateEnderecoDTO updateEnderecoDTO) {
        var updated = service.update(updateEnderecoDTO);
        return updated ? noContent(null) : notFound();
    }

    @Override
    @DeleteMapping(params = "id")
    public ResponseEntity deleteById(@PathParam("id") Integer id) {
        var deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
