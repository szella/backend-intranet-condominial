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
@Entity(name = "Andar")
@Table(name = "andar")
public class AndarEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pavimento_id", nullable = false)
    private PavimentoEntity pavimento;

    @OneToMany(mappedBy = "andar")
    private List<UnidadeEntity> unidades = new ArrayList<>();
}
