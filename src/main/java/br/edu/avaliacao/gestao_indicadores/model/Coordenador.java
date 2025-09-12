package br.edu.avaliacao.gestao_indicadores.model;

import jakarta.persistence.*;

@Entity
@Table(name="coordenadores", uniqueConstraints = {
        @UniqueConstraint(name="uk_coord_email", columnNames = "email")
})
public class Coordenador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String nome;

    @Column(nullable=false, length=100)
    private String email;

    @Column(nullable=false, length=50)
    private String cargo;

    @Column(nullable=false)
    private String senha;

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getCargo() { return cargo; } public void setCargo(String cargo) { this.cargo = cargo; }
    public String getSenha() { return senha; } public void setSenha(String senha) { this.senha = senha; }
}
