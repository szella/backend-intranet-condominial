package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class AndarSalvarRequest {
    private String nome;
    private String descricao;
    private Long pavimentoId;
}
