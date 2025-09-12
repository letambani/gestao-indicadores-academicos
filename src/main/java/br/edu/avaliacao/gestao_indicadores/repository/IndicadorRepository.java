package br.edu.avaliacao.gestao_indicadores.repository;

import br.edu.avaliacao.gestao_indicadores.model.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Long> {
    List<Indicador> findByCursoId(Long cursoId);
    List<Indicador> findByAnoAndPeriodo(Integer ano, Integer periodo);
    List<Indicador> findByCoordenadorId(Long coordenadorId);
}
