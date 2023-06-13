package br.com.szella.intranetcondominial.modal.entity;

import br.com.szella.intranetcondominial.enums.NivelAcessoEnum;
import br.com.szella.intranetcondominial.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "Funcionario")
@Table(name = "funcionario")
public class FuncionarioEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long matricula;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "predio_id")
    private PredioEntity predio;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    private NivelAcessoEnum nivelAcesso;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private CargoEntity cargo;

    @ManyToMany
    @JoinTable(
            name = "funcionario_telefone",
            joinColumns = {@JoinColumn(name = "funcionario_id")},
            inverseJoinColumns = {@JoinColumn(name = "telefone_id")}
    )
    private List<TelefoneEntity> telefones;

    @ManyToMany
    @JoinTable(
            name = "funcionario_funcionalidade",
            joinColumns = {@JoinColumn(name = "funcionario_id")},
            inverseJoinColumns = {@JoinColumn(name = "funcionalidade_id")}
    )
    private List<FuncionalidadeEntity> funcionalidades;
}
