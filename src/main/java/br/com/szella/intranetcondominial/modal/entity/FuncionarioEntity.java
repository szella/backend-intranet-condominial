package br.com.szella.intranetcondominial.modal.entity;

import br.com.szella.intranetcondominial.enums.NivelAcessoEnum;
import br.com.szella.intranetcondominial.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "funcao_id")
    private FuncaoEntity funcao;
}
