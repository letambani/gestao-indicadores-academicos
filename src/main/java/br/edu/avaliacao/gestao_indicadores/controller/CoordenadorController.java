package br.edu.avaliacao.gestao_indicadores.controller;

import br.edu.avaliacao.gestao_indicadores.model.Coordenador;
import br.edu.avaliacao.gestao_indicadores.model.Indicador;
import br.edu.avaliacao.gestao_indicadores.service.CoordenadorService;
import br.edu.avaliacao.gestao_indicadores.service.IndicadorService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    private final CoordenadorService service;
    private final IndicadorService indicadorService;

    public CoordenadorController(CoordenadorService service, IndicadorService indicadorService){
        this.service = service; this.indicadorService = indicadorService;
    }

    @PostMapping
    public ResponseEntity<Coordenador> criar(@RequestBody Coordenador c){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordenador> porId(@PathVariable Long id){
        return service.porId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Coordenador c){
        c.setId(id);
        service.salvar(c);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/indicadores")
    public ResponseEntity<List<Indicador>> indicadores(@PathVariable Long id){
        return ResponseEntity.ok(indicadorService.porCoordenador(id));
    }
}
