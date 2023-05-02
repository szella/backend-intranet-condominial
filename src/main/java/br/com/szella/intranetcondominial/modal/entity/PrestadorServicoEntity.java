package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PrestadorServico")
@Table(name = "prestador-servico")
public class PrestadorServicoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private PredioEntity predio;
}
