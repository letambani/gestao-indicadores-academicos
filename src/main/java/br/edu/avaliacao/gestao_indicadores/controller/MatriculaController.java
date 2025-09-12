package br.edu.avaliacao.gestao_indicadores.controller;

import br.edu.avaliacao.gestao_indicadores.dto.MatriculaDTO;
import br.edu.avaliacao.gestao_indicadores.model.Matricula;
import br.edu.avaliacao.gestao_indicadores.model.Rematricula;
import br.edu.avaliacao.gestao_indicadores.service.MatriculaService;
import br.edu.avaliacao.gestao_indicadores.service.RematriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// ⛔ remova: import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService service;
    private final RematriculaService rematriculaService;

    public MatriculaController(MatriculaService service, RematriculaService rematriculaService){
        this.service = service; this.rematriculaService = rematriculaService;
    }

    @PostMapping
    public ResponseEntity<Matricula> criar(@RequestBody MatriculaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> porId(@PathVariable Long id){
        return service.porId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody MatriculaDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/rematricula")
    public ResponseEntity<Rematricula> rematricula(@PathVariable Long id){
        return rematriculaService.porMatricula(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
