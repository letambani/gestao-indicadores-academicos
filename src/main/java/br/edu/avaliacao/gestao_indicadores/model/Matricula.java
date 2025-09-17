package br.edu.avaliacao.gestao_indicadores.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="matricula", uniqueConstraints = {
        @UniqueConstraint(name="uk_aluno_ano_periodo", columnNames = {"aluno_id","ano","periodo"})
})
public class Matricula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="aluno_id", nullable=false)
    private Aluno aluno;

    @ManyToOne(optional=false)
    @JoinColumn(name="curso_id", nullable=false)
    private Curso curso;

    @Column(name="data_matricula", nullable=false)
    private LocalDate dataMatricula;

    @Column(nullable=false) private Integer ano;
    @Column(nullable=false) private Integer periodo;

    @Column(nullable=false, length=20)
    private String status = "ATIVA";

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Aluno getAluno() { return aluno; } public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Curso getCurso() { return curso; } public void setCurso(Curso curso) { this.curso = curso; }
    public LocalDate getDataMatricula() { return dataMatricula; } public void setDataMatricula(LocalDate dataMatricula) { this.dataMatricula = dataMatricula; }
    public Integer getAno() { return ano; } public void setAno(Integer ano) { this.ano = ano; }
    public Integer getPeriodo() { return periodo; } public void setPeriodo(Integer periodo) { this.periodo = periodo; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
}
