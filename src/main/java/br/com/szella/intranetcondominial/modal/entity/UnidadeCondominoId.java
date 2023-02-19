package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UnidadeCondominoId implements Serializable {

    @Column(name = "unidade_id")
    private Long unidadeId;

    @Column(name = "codomino_id")
    private Long codominoId;
}
