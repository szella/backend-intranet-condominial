package br.com.szella.intranetcondominial.modal.entity;

import br.com.szella.intranetcondominial.enums.PeriodoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Evento")
@Table(name = "evento")
public class EventoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "local_evento_id", nullable = false)
    private LocalEventoEntity localEvento;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String locatario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PeriodoEnum periodo;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;
    private String observacao;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;
}
