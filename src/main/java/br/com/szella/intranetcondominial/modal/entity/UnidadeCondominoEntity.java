package br.com.szella.intranetcondominial.modal.entity;

import br.com.szella.intranetcondominial.enums.TipoCondominoEnum;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "UnidadeCondomino")
@Table(name = "unidade-condomino")
public class UnidadeCondominoEntity {

    @EmbeddedId
    private UnidadeCondominoId unidadeCondominoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("unidadeId")
    private UnidadeEntity unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codominoId")
    private CondominoEntity condomino;

    private LocalDateTime entrada;

    private LocalDateTime saida;

    @Enumerated(EnumType.STRING)
    private TipoCondominoEnum tipoCondomino;
}
