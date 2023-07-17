package br.com.groupfive.jobby.controller;

import br.com.groupfive.jobby.dto.cadastro.CadastroDTO;
import br.com.groupfive.jobby.service.interfaces.IRecrutamentoService;
import jakarta.websocket.server.PathParam;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import static br.com.groupfive.jobby.utils.ResponseEntityUtils.notFound;
import static br.com.groupfive.jobby.utils.ResponseEntityUtils.ok;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("/recrutamento")
public class RecrutamentoController {

    private final IRecrutamentoService<Integer> service;

    public RecrutamentoController(IRecrutamentoService<Integer> service) {
        this.service = service;
    }


    @GetMapping(params = "profissao")
    public ResponseEntity<List<CadastroDTO>> findByProfissao(@PathParam("profissao") String profissao) {
        var dtoList = service.findByProfissao(profissao);
        return isNull(dtoList) ? notFound() : ok(dtoList);
    }

    @GetMapping(value = "/habilidade", params = "nomeHabilidade")
    public ResponseEntity<List<CadastroDTO>> findByHabilidade(@PathParam("nomeHabilidade") String nomeHabilidade) {
        var dtoList = service.findByHabilidade(nomeHabilidade);
        return isNull(dtoList) ? notFound() : ok(dtoList);
    }

    @GetMapping(value = "/habilidadeNot", params = "nomeHabilidade")
    public ResponseEntity<List<CadastroDTO>> findByHabilidadeNot(@PathParam("nomeHabilidade") String nomeHabilidade) {
        var dtoList = service.findByHabilidadeNot(nomeHabilidade);
        return isNull(dtoList) ? notFound() : ok(dtoList);
    }

    @GetMapping("candidatos")
    public ResponseEntity<List<CadastroDTO>> findAll() {
        var dtoList = service.findAll();
        return isNull(dtoList) ? notFound() : ok(dtoList);
    }

    @GetMapping(value = "/count/habilidade", params = "habilidade")
    public ResponseEntity<String> countCadastroForHabilidade(@PathParam("habilidade") String habilidade) {
        var count = service.countCadastroForHabilidade(habilidade);
        String string = "{\n\"count\": " + count + "\n}";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(string);
    }

    @GetMapping(value = "/count/habilidadeNot", params = "habilidade")
    public ResponseEntity<String> countCadastroHaveNotHabilidade(@PathParam("habilidade") String habilidade) {
        Long countCadastroHaveNotHabilidade = service.countCadastroHaveNotHabilidade(habilidade);
        String string = "{\n\"count\": " + countCadastroHaveNotHabilidade + "\n}";
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(string);
    }


    @GetMapping(value = "/filterDataContratacao")
    public ResponseEntity<List<CadastroDTO>> findByDataContratacaoBetween(
        @RequestParam(required = true, value = "initialDate") LocalDate initialDate,
        @RequestParam(required = true, value = "initialDate") LocalDate finalDate
    ) {
        var dtoList = service.findByDataContratacaoBetween(initialDate, finalDate);
        return isNull(dtoList) ? notFound() : ok(dtoList);
    }
}
