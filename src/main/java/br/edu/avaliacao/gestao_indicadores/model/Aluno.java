package br.edu.avaliacao.gestao_indicadores.model;

import jakarta.persistence.*;

@Entity
@Table(name="alunos", uniqueConstraints = {
        @UniqueConstraint(name="uk_aluno_cpf", columnNames = "cpf")
})
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="curso_id", nullable=false)
    private Curso curso;

    @Column(nullable=false, length=100)
    private String nome;

    @Column(nullable=false, length=11)
    private String cpf;

    @Column(nullable=false, length=100)
    private String email;

    @Column(nullable=false, length=20)
    private String status = "MATRICULADO";

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Curso getCurso() { return curso; } public void setCurso(Curso curso) { this.curso = curso; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; } public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
}
