package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class PavimentoSalvarRequest {
    private Integer pavimento;
    private String nome;
    private String descricao;
    private Long predioId;
}
