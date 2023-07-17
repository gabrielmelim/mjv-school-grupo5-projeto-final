package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.ICadastroController;
import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.CreateCadastroDTO;
import br.com.groupfive.jobby.dto.cadastro.UpdateCadastroDTO;
import br.com.groupfive.jobby.service.interfaces.ICadastroService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("cadastro")
public class CadastroController<T> implements ICadastroController<Integer> {

    private final ICadastroService<Integer> service;

    public CadastroController(ICadastroService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CadastroDTO> findById(@PathVariable("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<CadastroDTO> create(@RequestBody CreateCadastroDTO createCadastroDTO) {
        var dto = service.create(createCadastroDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }

    //TODO Analisar método
    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(
        @RequestBody UpdateCadastroDTO updateCadastroDTO,
        @PathVariable("id") Integer id
    ) {
        var updated = service.update(updateCadastroDTO, id);
        return updated ? noContent(null) : notFound();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        var deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
