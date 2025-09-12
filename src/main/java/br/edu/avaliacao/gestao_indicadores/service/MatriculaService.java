package br.edu.avaliacao.gestao_indicadores.service;

import br.edu.avaliacao.gestao_indicadores.dto.MatriculaDTO;
import br.edu.avaliacao.gestao_indicadores.exception.ResourceNotFoundException;
import br.edu.avaliacao.gestao_indicadores.model.*;
import br.edu.avaliacao.gestao_indicadores.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    private final MatriculaRepository repo;
    private final AlunoRepository alunoRepo;
    private final CursoRepository cursoRepo;

    public MatriculaService(MatriculaRepository repo, AlunoRepository alunoRepo, CursoRepository cursoRepo){
        this.repo = repo; this.alunoRepo = alunoRepo; this.cursoRepo = cursoRepo;
    }

    public Matricula criar(MatriculaDTO dto){
        Aluno aluno = alunoRepo.findById(dto.alunoId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + dto.alunoId));
        Curso curso = cursoRepo.findById(dto.cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + dto.cursoId));
        Matricula m = new Matricula();
        m.setAluno(aluno);
        m.setCurso(curso);
        m.setDataMatricula(LocalDate.parse(dto.dataMatricula));
        m.setAno(dto.ano);
        m.setPeriodo(dto.periodo);
        if(dto.status != null) m.setStatus(dto.status);
        return repo.save(m);
    }

    public Optional<Matricula> porId(Long id){ return repo.findById(id); }
    public List<Matricula> listar(){ return repo.findAll(); }

    public void atualizar(Long id, MatriculaDTO dto){
        Matricula m = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada: " + id));
        if(dto.alunoId != null){
            Aluno aluno = alunoRepo.findById(dto.alunoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + dto.alunoId));
            m.setAluno(aluno);
        }
        if(dto.cursoId != null){
            Curso curso = cursoRepo.findById(dto.cursoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + dto.cursoId));
            m.setCurso(curso);
        }
        if(dto.dataMatricula != null) m.setDataMatricula(LocalDate.parse(dto.dataMatricula));
        if(dto.ano != null) m.setAno(dto.ano);
        if(dto.periodo != null) m.setPeriodo(dto.periodo);
        if(dto.status != null) m.setStatus(dto.status);
        repo.save(m);
    }

    public void deletar(Long id){ repo.deleteById(id); }

    public List<Matricula> porCurso(Long cursoId){ return repo.findByCursoId(cursoId); }
    public List<Matricula> porAluno(Long alunoId){ return repo.findByAlunoId(alunoId); }
}
