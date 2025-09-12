package br.edu.avaliacao.gestao_indicadores.controller;

import br.edu.avaliacao.gestao_indicadores.dto.IndicadorDTO;
import br.edu.avaliacao.gestao_indicadores.model.Indicador;
import br.edu.avaliacao.gestao_indicadores.service.IndicadorService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indicador")
public class IndicadorController {

    private final IndicadorService service;
    public IndicadorController(IndicadorService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Indicador> criar(@RequestBody IndicadorDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Indicador> porId(@PathVariable Long id){
        return service.porId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody IndicadorDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Comparar cursos por ano/período
    @GetMapping
    public ResponseEntity<List<Indicador>> porAnoPeriodo(@RequestParam Integer ano, @RequestParam Integer periodo){
        return ResponseEntity.ok(service.porAnoPeriodo(ano, periodo));
    }
}
