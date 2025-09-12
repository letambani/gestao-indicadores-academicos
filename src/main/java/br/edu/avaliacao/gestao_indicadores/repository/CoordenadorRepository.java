package br.edu.avaliacao.gestao_indicadores.repository;

import br.edu.avaliacao.gestao_indicadores.model.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {}
