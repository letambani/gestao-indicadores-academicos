package br.edu.avaliacao.gestao_indicadores.repository;

import br.edu.avaliacao.gestao_indicadores.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByCursoId(Long cursoId);
}
