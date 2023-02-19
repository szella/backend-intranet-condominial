package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Condomino")
@Table(name = "condomino")
public class CondominoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String documento;

    @OneToMany(
            mappedBy = "condomino",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UnidadeCondominoEntity> unidades;
}
