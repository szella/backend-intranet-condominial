package br.com.szella.intranetcondominial.modal.request;

import br.com.szella.intranetcondominial.enums.PeriodoEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventoSalvarEditarRequest {
    private Long localEventoId;
    private LocalDate data;
    private String locatario;
    private PeriodoEnum periodo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String observacao;
}
