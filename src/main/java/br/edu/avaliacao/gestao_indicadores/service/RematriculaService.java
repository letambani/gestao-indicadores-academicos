package br.edu.avaliacao.gestao_indicadores.service;

import br.edu.avaliacao.gestao_indicadores.dto.RematriculaDTO;
import br.edu.avaliacao.gestao_indicadores.exception.ResourceNotFoundException;
import br.edu.avaliacao.gestao_indicadores.model.*;
import br.edu.avaliacao.gestao_indicadores.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class RematriculaService {
    private final RematriculaRepository repo;
    private final MatriculaRepository matriculaRepo;
    private final CoordenadorRepository coordRepo;

    public RematriculaService(RematriculaRepository repo, MatriculaRepository matriculaRepo, CoordenadorRepository coordRepo){
        this.repo = repo; this.matriculaRepo = matriculaRepo; this.coordRepo = coordRepo;
    }

    public Rematricula criar(RematriculaDTO dto){
        Matricula m = matriculaRepo.findById(dto.matriculaId)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada: " + dto.matriculaId));
        Rematricula r = new Rematricula();
        r.setMatricula(m);
        if(dto.coordenadorId != null){
            Coordenador c = coordRepo.findById(dto.coordenadorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Coordenador não encontrado: " + dto.coordenadorId));
            r.setCoordenador(c);
        }
        r.setDataSolicitacao(LocalDate.parse(dto.dataSolicitacao));
        if(dto.dataAnalise != null) r.setDataAnalise(LocalDate.parse(dto.dataAnalise));
        if(dto.status != null) r.setStatus(dto.status);
        r.setObservacao(dto.observacao);
        return repo.save(r);
    }

    public Optional<Rematricula> porId(Long id){ return repo.findById(id); }

    public Optional<Rematricula> porMatricula(Long matriculaId){
        return repo.findByMatriculaId(matriculaId);
    }

    public void atualizar(Long id, RematriculaDTO dto){
        Rematricula r = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rematrícula não encontrada: " + id));
        if(dto.matriculaId != null){
            Matricula m = matriculaRepo.findById(dto.matriculaId)
                    .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada: " + dto.matriculaId));
            r.setMatricula(m);
        }
        if(dto.coordenadorId != null){
            Coordenador c = coordRepo.findById(dto.coordenadorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Coordenador não encontrado: " + dto.coordenadorId));
            r.setCoordenador(c);
        }
        if(dto.dataSolicitacao != null) r.setDataSolicitacao(LocalDate.parse(dto.dataSolicitacao));
        if(dto.dataAnalise != null) r.setDataAnalise(LocalDate.parse(dto.dataAnalise));
        if(dto.status != null) r.setStatus(dto.status);
        if(dto.observacao != null) r.setObservacao(dto.observacao);
        repo.save(r);
    }

    public void deletar(Long id){ repo.deleteById(id); }
}
