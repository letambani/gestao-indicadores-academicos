package br.edu.avaliacao.gestao_indicadores.repository;

import br.edu.avaliacao.gestao_indicadores.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByCursoId(Long cursoId);
    List<Matricula> findByAlunoId(Long alunoId);
}
