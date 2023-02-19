package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnidadeResponse {
    private Long id;
    private String nome;
    private String descricao;
}
