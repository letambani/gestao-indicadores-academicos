package br.edu.avaliacao.gestao_indicadores.repository;

import br.edu.avaliacao.gestao_indicadores.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {}
