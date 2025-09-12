package br.edu.avaliacao.gestao_indicadores.repository;

import br.edu.avaliacao.gestao_indicadores.model.Rematricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RematriculaRepository extends JpaRepository<Rematricula, Long> {
    Optional<Rematricula> findByMatriculaId(Long matriculaId);
}
