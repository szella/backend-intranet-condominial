package br.com.szella.intranetcondominial.modal.request;

import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LocalEventoSalvarEditarRequest {
    private String nome;
    private BigDecimal valor;
    private Long predioId;
}
