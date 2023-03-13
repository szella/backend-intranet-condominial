package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LocalEventoResponse {
    private Long id;
    private String nome;
    private BigDecimal valor;
    private PredioResponse predio;
}
