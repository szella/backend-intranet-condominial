package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Entity(name = "PrestadorServico")
@Table(name = "prestador_servico")
public class PrestadorServicoEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String atividade;
    private String empresa;

    @OneToMany(mappedBy = "prestadorServico")
    private List<PrestadorServicoServicoEntity> servicos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "prestador_servico_telefone",
            joinColumns = {@JoinColumn(name = "prestador_servico_id")},
            inverseJoinColumns = {@JoinColumn(name = "telefone_id")}
    )
    private List<TelefoneEntity> telefone;
}
