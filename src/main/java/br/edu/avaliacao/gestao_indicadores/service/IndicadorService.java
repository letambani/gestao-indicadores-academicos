package br.edu.avaliacao.gestao_indicadores.service;

import br.edu.avaliacao.gestao_indicadores.dto.IndicadorDTO;
import br.edu.avaliacao.gestao_indicadores.exception.ResourceNotFoundException;
import br.edu.avaliacao.gestao_indicadores.model.*;
import br.edu.avaliacao.gestao_indicadores.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IndicadorService {
    private final IndicadorRepository repo;
    private final CursoRepository cursoRepo;
    private final CoordenadorRepository coordRepo;

    public IndicadorService(IndicadorRepository repo, CursoRepository cursoRepo, CoordenadorRepository coordRepo){
        this.repo = repo; this.cursoRepo = cursoRepo; this.coordRepo = coordRepo;
    }

    public Indicador criar(IndicadorDTO dto){
        Curso curso = cursoRepo.findById(dto.cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + dto.cursoId));
        Coordenador coord = coordRepo.findById(dto.coordenadorId)
                .orElseThrow(() -> new ResourceNotFoundException("Coordenador não encontrado: " + dto.coordenadorId));
        Indicador i = new Indicador();
        i.setCurso(curso);
        i.setCoordenador(coord);
        i.setAno(dto.ano);
        i.setPeriodo(dto.periodo);
        i.setTotalMatriculados(dto.totalMatriculados);
        i.setTotalRematriculados(dto.totalRematriculados);
        i.setEvadidos(dto.evadidos);
        i.setTaxaEvasao(dto.taxaEvasao);
        i.setTaxaRematricula(dto.taxaRematricula);
        i.setDataGeracao(LocalDate.parse(dto.dataGeracao));
        i.setObservacao(dto.observacao);
        return repo.save(i);
    }

    public Optional<Indicador> porId(Long id){ return repo.findById(id); }

    public void atualizar(Long id, IndicadorDTO dto){
        Indicador i = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Indicador não encontrado: " + id));
        if(dto.cursoId != null){
            Curso c = cursoRepo.findById(dto.cursoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado: " + dto.cursoId));
            i.setCurso(c);
        }
        if(dto.coordenadorId != null){
            Coordenador co = coordRepo.findById(dto.coordenadorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Coordenador não encontrado: " + dto.coordenadorId));
            i.setCoordenador(co);
        }
        if(dto.ano != null) i.setAno(dto.ano);
        if(dto.periodo != null) i.setPeriodo(dto.periodo);
        if(dto.totalMatriculados != null) i.setTotalMatriculados(dto.totalMatriculados);
        if(dto.totalRematriculados != null) i.setTotalRematriculados(dto.totalRematriculados);
        if(dto.evadidos != null) i.setEvadidos(dto.evadidos);
        if(dto.taxaEvasao != null) i.setTaxaEvasao(dto.taxaEvasao);
        if(dto.taxaRematricula != null) i.setTaxaRematricula(dto.taxaRematricula);
        if(dto.dataGeracao != null) i.setDataGeracao(LocalDate.parse(dto.dataGeracao));
        if(dto.observacao != null) i.setObservacao(dto.observacao);
        repo.save(i);
    }

    public void deletar(Long id){ repo.deleteById(id); }

    public List<Indicador> porCurso(Long cursoId){ return repo.findByCursoId(cursoId); }
    public List<Indicador> porAnoPeriodo(Integer ano, Integer periodo){ return repo.findByAnoAndPeriodo(ano, periodo); }
    public List<Indicador> porCoordenador(Long coordId){ return repo.findByCoordenadorId(coordId); }
}
