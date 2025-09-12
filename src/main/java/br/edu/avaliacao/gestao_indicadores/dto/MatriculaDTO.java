package br.edu.avaliacao.gestao_indicadores.dto;

public class MatriculaDTO {
    public Long alunoId;
    public Long cursoId;
    public String dataMatricula; // yyyy-MM-dd
    public Integer ano;
    public Integer periodo;
    public String status; // ATIVA/TRANCADA/CANCELADA
}
