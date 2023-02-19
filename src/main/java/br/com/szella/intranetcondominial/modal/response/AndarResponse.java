package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AndarResponse {
    private Long id;
    private String nome;
    private String descricao;
}
