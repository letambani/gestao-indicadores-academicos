package br.edu.avaliacao.gestao_indicadores.dto;

public class RematriculaDTO {
    public Long matriculaId;
    public Long coordenadorId;   // opcional no POST
    public String dataSolicitacao; // yyyy-MM-dd
    public String dataAnalise;     // opcional
    public String status;          // SOLICITADA/APROVADA/RECUSADA
    public String observacao;      // opcional
}
