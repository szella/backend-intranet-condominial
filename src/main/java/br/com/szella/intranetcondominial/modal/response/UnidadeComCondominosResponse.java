package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UnidadeComCondominosResponse {
    private Long id;
    private String nome;
    private String descricao;
    private List<CondominoResponse> condominos;
}
