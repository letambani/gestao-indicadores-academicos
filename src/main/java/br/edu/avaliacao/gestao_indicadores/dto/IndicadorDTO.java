package br.edu.avaliacao.gestao_indicadores.dto;

public class IndicadorDTO {
    public Long cursoId;
    public Long coordenadorId;
    public Integer ano;
    public Integer periodo;
    public Integer totalMatriculados;
    public Integer totalRematriculados;
    public Integer evadidos;
    public Double taxaEvasao;
    public Double taxaRematricula;
    public String dataGeracao; // yyyy-MM-dd
    public String observacao;  // opcional no PUT
}
