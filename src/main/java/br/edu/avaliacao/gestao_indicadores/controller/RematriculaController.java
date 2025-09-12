package br.edu.avaliacao.gestao_indicadores.controller;

import br.edu.avaliacao.gestao_indicadores.dto.RematriculaDTO;
import br.edu.avaliacao.gestao_indicadores.model.Rematricula;
import br.edu.avaliacao.gestao_indicadores.service.RematriculaService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rematricula")
public class RematriculaController {

    private final RematriculaService service;
    public RematriculaController(RematriculaService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Rematricula> criar(@RequestBody RematriculaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rematricula> porId(@PathVariable Long id){
        return service.porId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody RematriculaDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
