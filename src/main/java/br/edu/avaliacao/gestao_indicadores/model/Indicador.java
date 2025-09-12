package br.edu.avaliacao.gestao_indicadores.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="indicadores", uniqueConstraints = {
        @UniqueConstraint(name="uk_curso_ano_periodo", columnNames = {"curso_id","ano","periodo"})
})
public class Indicador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="curso_id", nullable=false)
    private Curso curso;

    @ManyToOne(optional=false)
    @JoinColumn(name="coordenador_id", nullable=false)
    private Coordenador coordenador;

    @Column(nullable=false) private Integer ano;
    @Column(nullable=false) private Integer periodo;

    @Column(name="total_matriculados", nullable=false) private Integer totalMatriculados;
    @Column(name="total_rematriculados", nullable=false) private Integer totalRematriculados;
    @Column(nullable=false) private Integer evadidos;

    @Column(name="taxa_evasao", nullable=false) private Double taxaEvasao;
    @Column(name="taxa_rematricula", nullable=false) private Double taxaRematricula;

    @Column(name="data_geracao", nullable=false)
    private LocalDate dataGeracao;

    @Column(length=500)
    private String observacao;

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Curso getCurso() { return curso; } public void setCurso(Curso curso) { this.curso = curso; }
    public Coordenador getCoordenador() { return coordenador; } public void setCoordenador(Coordenador coordenador) { this.coordenador = coordenador; }
    public Integer getAno() { return ano; } public void setAno(Integer ano) { this.ano = ano; }
    public Integer getPeriodo() { return periodo; } public void setPeriodo(Integer periodo) { this.periodo = periodo; }
    public Integer getTotalMatriculados() { return totalMatriculados; } public void setTotalMatriculados(Integer totalMatriculados) { this.totalMatriculados = totalMatriculados; }
    public Integer getTotalRematriculados() { return totalRematriculados; } public void setTotalRematriculados(Integer totalRematriculados) { this.totalRematriculados = totalRematriculados; }
    public Integer getEvadidos() { return evadidos; } public void setEvadidos(Integer evadidos) { this.evadidos = evadidos; }
    public Double getTaxaEvasao() { return taxaEvasao; } public void setTaxaEvasao(Double taxaEvasao) { this.taxaEvasao = taxaEvasao; }
    public Double getTaxaRematricula() { return taxaRematricula; } public void setTaxaRematricula(Double taxaRematricula) { this.taxaRematricula = taxaRematricula; }
    public LocalDate getDataGeracao() { return dataGeracao; } public void setDataGeracao(LocalDate dataGeracao) { this.dataGeracao = dataGeracao; }
    public String getObservacao() { return observacao; } public void setObservacao(String observacao) { this.observacao = observacao; }
}
