package br.edu.avaliacao.gestao_indicadores.service;

import br.edu.avaliacao.gestao_indicadores.model.Coordenador;
import br.edu.avaliacao.gestao_indicadores.repository.CoordenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {
    private final CoordenadorRepository repo;
    public CoordenadorService(CoordenadorRepository repo){ this.repo = repo; }

    public Coordenador salvar(Coordenador c){ return repo.save(c); }
    public Optional<Coordenador> porId(Long id){ return repo.findById(id); }
    public List<Coordenador> listar(){ return repo.findAll(); }
    public void deletar(Long id){ repo.deleteById(id); }
}
