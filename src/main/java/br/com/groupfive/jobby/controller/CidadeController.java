package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.controller.interfaces.ICidadeController;
import br.com.groupfive.jobby.dto.cidade.CidadeDTO;
import br.com.groupfive.jobby.dto.cidade.CreateCidadeDTO;
import br.com.groupfive.jobby.dto.cidade.UpdateCidadeDTO;
import br.com.groupfive.jobby.service.interfaces.ICidadeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.*;
import static br.com.groupfive.jobby.utils.ResponseEntityUtils.created;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("cidade")
public class CidadeController implements ICidadeController<Integer> {

    private final ICidadeService<Integer> service;

    public CidadeController(ICidadeService<Integer> service) {
        this.service = service;
    }


    @GetMapping()
    public String status() {
        return "ok";
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> findById(@PathParam("id") Integer id) {
        var dto = service.findById(id);
        return isNull(dto) ? notFound() : ok(dto);
    }

    @Override
    public ResponseEntity<CidadeDTO> create(CreateCidadeDTO createCidadeDTO) {
        var dto = service.create(createCidadeDTO);
        return isNull(dto) ? unaprocessableEntity() : created(dto);

    }

    @Override
    public ResponseEntity update(UpdateCidadeDTO updateCidadeDTO, Integer id) {
        var updated = service.update(updateCidadeDTO, id);
        return updated ? noContent(null) : notFound();

    }

    @Override
    public ResponseEntity deleteById(Integer id) {
        var deleted = service.deleteById(id);
        return deleted ? noContent(null) : notFound();
    }
}
