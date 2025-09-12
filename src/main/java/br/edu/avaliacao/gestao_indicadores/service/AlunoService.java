package br.edu.avaliacao.gestao_indicadores.service;

import br.edu.avaliacao.gestao_indicadores.dto.AlunoDTO;
import br.edu.avaliacao.gestao_indicadores.exception.ResourceNotFoundException;
import br.edu.avaliacao.gestao_indicadores.model.Aluno;
import br.edu.avaliacao.gestao_indicadores.model.Curso;
import br.edu.avaliacao.gestao_indicadores.repository.AlunoRepository;
import br.edu.avaliacao.gestao_indicadores.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository repo;
    private final CursoRepository cursoRepo;

    public AlunoService(AlunoRepository repo, CursoRepository cursoRepo) {
        this.repo = repo; this.cursoRepo = cursoRepo;
    }

    public Aluno criar(AlunoDTO dto){
        Curso curso = cursoRepo.findById(dto.cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + dto.cursoId));
        Aluno a = new Aluno();
        a.setCurso(curso);
        a.setNome(dto.nome);
        a.setCpf(dto.cpf);
        a.setEmail(dto.email);
        if(dto.status != null) a.setStatus(dto.status);
        return repo.save(a);
    }

    public Optional<Aluno> porId(Long id){ return repo.findById(id); }
    public List<Aluno> listar(){ return repo.findAll(); }

    public void atualizar(Long id, AlunoDTO dto){
        Aluno a = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + id));
        if(dto.cursoId != null){
            Curso c = cursoRepo.findById(dto.cursoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + dto.cursoId));
            a.setCurso(c);
        }
        if(dto.nome != null) a.setNome(dto.nome);
        if(dto.cpf != null) a.setCpf(dto.cpf);
        if(dto.email != null) a.setEmail(dto.email);
        if(dto.status != null) a.setStatus(dto.status);
        repo.save(a);
    }

    public void deletar(Long id){ repo.deleteById(id); }

    public List<Aluno> listarPorCurso(Long cursoId){ return repo.findByCursoId(cursoId); }
}
