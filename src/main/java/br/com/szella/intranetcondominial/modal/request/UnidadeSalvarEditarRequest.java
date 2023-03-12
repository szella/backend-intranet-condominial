package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class UnidadeSalvarEditarRequest {
    private Long id;
    private String nome;
    private Integer posicao;
}
