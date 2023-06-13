package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.Entity;
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

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PrestadorServicoServico")
@Table(name = "prestador_servico_servico")
public class PrestadorServicoServicoEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String descricao;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "predio_id", nullable = false)
    private PredioEntity predio;

    @ManyToOne
    @JoinColumn(name = "prestador_servico_id", nullable = false)
    private PrestadorServicoEntity prestadorServico;
}
