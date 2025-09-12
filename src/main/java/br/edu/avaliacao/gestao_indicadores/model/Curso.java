package br.edu.avaliacao.gestao_indicadores.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String nome;

    @Column(nullable=false, length=20)
    private String sigla;

    @Column(columnDefinition="TEXT")
    private String descricao;

    @Column(name="duracao_semestres", nullable=false)
    private Integer duracaoSemestres;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos = new ArrayList<>();

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getSigla() { return sigla; } public void setSigla(String sigla) { this.sigla = sigla; }
    public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getDuracaoSemestres() { return duracaoSemestres; } public void setDuracaoSemestres(Integer duracaoSemestres) { this.duracaoSemestres = duracaoSemestres; }
    public List<Aluno> getAlunos() { return alunos; } public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
}
