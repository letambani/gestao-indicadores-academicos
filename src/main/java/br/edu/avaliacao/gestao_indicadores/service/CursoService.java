package br.edu.avaliacao.gestao_indicadores.service;

import br.edu.avaliacao.gestao_indicadores.model.Curso;
import br.edu.avaliacao.gestao_indicadores.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository repo;
    public CursoService(CursoRepository repo){ this.repo = repo; }

    public Curso salvar(Curso c){ return repo.save(c); }
    public Optional<Curso> porId(Long id){ return repo.findById(id); }
    public List<Curso> listar(){ return repo.findAll(); }
    public void deletar(Long id){ repo.deleteById(id); }
}
