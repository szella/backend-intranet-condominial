package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Pavimento")
@Table(name = "pavimento")
public class PavimentoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer pavimento;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "predio_id", nullable = false)
    private PredioEntity predio;

    @OneToMany(mappedBy = "pavimento")
    private List<AndarEntity> andares = new ArrayList<>();
}
