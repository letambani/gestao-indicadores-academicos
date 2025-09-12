package br.edu.avaliacao.gestao_indicadores.controller;

import br.edu.avaliacao.gestao_indicadores.model.*;
import br.edu.avaliacao.gestao_indicadores.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;
    private final MatriculaService matriculaService;
    private final IndicadorService indicadorService;
    private final AlunoService alunoService;

    public CursoController(CursoService cursoService,
                           MatriculaService matriculaService,
                           IndicadorService indicadorService,
                           AlunoService alunoService) {
        this.cursoService = cursoService;
        this.matriculaService = matriculaService;
        this.indicadorService = indicadorService;
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso c){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.salvar(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> porId(@PathVariable Long id){
        return cursoService.porId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Curso c){
        if (cursoService.porId(id).isEmpty()) return ResponseEntity.notFound().build();
        c.setId(id);
        cursoService.salvar(c);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        cursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // Relacionamentos
    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<Aluno>> alunosDoCurso(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.listarPorCurso(id));
    }

    @GetMapping("/{id}/matriculas")
    public ResponseEntity<List<Matricula>> matriculasDoCurso(@PathVariable Long id){
        return ResponseEntity.ok(matriculaService.porCurso(id));
    }

    @GetMapping("/{id}/indicadores")
    public ResponseEntity<List<Indicador>> indicadoresDoCurso(@PathVariable Long id){
        return ResponseEntity.ok(indicadorService.porCurso(id));
    }
}
