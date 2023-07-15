package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.IProfissaoController;
import br.com.groupfive.jobby.dto.profissao.CreateProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.ProfissaoDTO;
import br.com.groupfive.jobby.dto.profissao.UpdateProfissaoDTO;
import br.com.groupfive.jobby.service.interfaces.IProfissaoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static br.com.groupfive.jobby.utils.ResponseEntityUtils.created;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("profissao")
public class ProfissaoController implements IProfissaoController<Integer> {

    private final IProfissaoService<Integer> service;

    public ProfissaoController(IProfissaoService<Integer> service) {
        this.service = service;
    }

    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProfissaoDTO> findById(Integer id) {
        ProfissaoDTO dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    @PostMapping
    public ResponseEntity<ProfissaoDTO> create(CreateProfissaoDTO createProfissaoDTO) {
        ProfissaoDTO dto = service.create(createProfissaoDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity update(
        @RequestBody UpdateProfissaoDTO updateProfissaoDTO,
        @PathParam("id") Integer id
    ) {
        boolean updated = service.update(updateProfissaoDTO, id);
        return updated ? noContent(null) : notFound();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathParam("id") Integer id) {
        boolean deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
