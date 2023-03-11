package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class AndarSalvarEditarRequest {
    private Long id;
    private String nome;
    private String descricao;
    private Integer posicao;
}
