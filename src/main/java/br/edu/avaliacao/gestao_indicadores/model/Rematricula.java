package br.edu.avaliacao.gestao_indicadores.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="rematricula")
public class Rematricula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="matricula_id", nullable=false)
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name="coordenador_id")
    private Coordenador coordenador;

    @Column(name="data_solicitacao", nullable=false)
    private LocalDate dataSolicitacao;

    @Column(name="data_analise")
    private LocalDate dataAnalise;

    @Column(nullable=false, length=20)
    private String status = "SOLICITADA";

    @Column(columnDefinition="TEXT")
    private String observacao;

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Matricula getMatricula() { return matricula; } public void setMatricula(Matricula matricula) { this.matricula = matricula; }
    public Coordenador getCoordenador() { return coordenador; } public void setCoordenador(Coordenador coordenador) { this.coordenador = coordenador; }
    public LocalDate getDataSolicitacao() { return dataSolicitacao; } public void setDataSolicitacao(LocalDate dataSolicitacao) { this.dataSolicitacao = dataSolicitacao; }
    public LocalDate getDataAnalise() { return dataAnalise; } public void setDataAnalise(LocalDate dataAnalise) { this.dataAnalise = dataAnalise; }
    public String getStatus() { return status; } public void setStatus(String status) { this.status = status; }
    public String getObservacao() { return observacao; } public void setObservacao(String observacao) { this.observacao = observacao; }
}
