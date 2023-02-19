package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CondominoResponse {
    private Long id;
    private String nome;
    private String documento;
    private boolean proprietario;
}
