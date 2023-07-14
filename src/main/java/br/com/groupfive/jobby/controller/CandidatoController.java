package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.ICandidatoController;
import br.com.groupfive.jobby.dto.candidato.CandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.CreateCandidatoDTO;
import br.com.groupfive.jobby.dto.candidato.UpdateCandidatoDTO;
import br.com.groupfive.jobby.service.interfaces.ICandidatoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("candidato")
public class CandidatoController<T> implements ICandidatoController<Integer> {

    private final ICandidatoService<Integer> service;

    public CandidatoController(ICandidatoService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping(params = "id")
    public ResponseEntity<CandidatoDTO> findById(@PathParam("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @GetMapping(params = "name")
    public ResponseEntity<CandidatoDTO> findByName(String name) {
        var dto = service.findByName(name);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<CandidatoDTO> create(@RequestBody CreateCandidatoDTO createCandidatoDTO) {
        var dto = service.create(createCandidatoDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }

    //TODO Analisar método
    @Override
    @PutMapping(params = "id")
    public ResponseEntity update(
        @RequestBody UpdateCandidatoDTO updateCandidatoDTO,
        @RequestParam("id") Integer id
    ) {
        var updated = service.update(updateCandidatoDTO);
        return updated ? noContent(null) : notFound();
    }

    @Override
    @DeleteMapping(params = "id")
    public ResponseEntity deleteById(@PathParam("id") Integer id) {
        var deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
