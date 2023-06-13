package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Unidade")
@Table(name = "unidade")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UnidadeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "andar_id", nullable = false)
    private AndarEntity andar;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    private List<UnidadeCondominoEntity> condominos = new ArrayList<>();
}
