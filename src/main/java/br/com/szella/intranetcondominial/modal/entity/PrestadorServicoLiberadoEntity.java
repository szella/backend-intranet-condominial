package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PrestadorServicoLiberado")
@Table(name = "prestador-servico-liberado")
public class PrestadorServicoLiberadoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prestador_servico_id")
    private PrestadorServicoEntity PrestadorServico;

    private String nome;

    private String documento;
}
