package br.com.szella.intranetcondominial.modal.response;

import br.com.szella.intranetcondominial.enums.PeriodoEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class EventoResponse {
    private Long id;
    private LocalEventoResponse localEvento;
    private LocalDate data;
    private String locatario;
    private PeriodoEnum periodo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String observacao;
    private LocalDateTime dataRegistro;
}
