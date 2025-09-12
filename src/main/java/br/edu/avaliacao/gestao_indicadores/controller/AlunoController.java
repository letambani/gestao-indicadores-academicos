package br.edu.avaliacao.gestao_indicadores.controller;

import br.edu.avaliacao.gestao_indicadores.dto.AlunoDTO;
import br.edu.avaliacao.gestao_indicadores.model.Aluno;
import br.edu.avaliacao.gestao_indicadores.model.Matricula;
import br.edu.avaliacao.gestao_indicadores.service.AlunoService;
import br.edu.avaliacao.gestao_indicadores.service.MatriculaService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService service;
    private final MatriculaService matriculaService;

    public AlunoController(AlunoService service, MatriculaService matriculaService){
        this.service = service; this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> porId(@PathVariable Long id){
        return service.porId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody AlunoDTO dto){
        service.atualizar(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/matriculas")
    public ResponseEntity<List<Matricula>> matriculasDoAluno(@PathVariable Long id){
        return ResponseEntity.ok(matriculaService.porAluno(id));
    }
}
