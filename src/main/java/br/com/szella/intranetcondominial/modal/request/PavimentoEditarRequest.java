package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class PavimentoEditarRequest {
    private Integer pavimento;
    private String nome;
    private String descricao;
}
