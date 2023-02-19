package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PavimentoResponse {
    private Long id;
    private Integer pavimento;
    private String nome;
    private String descricao;
}
