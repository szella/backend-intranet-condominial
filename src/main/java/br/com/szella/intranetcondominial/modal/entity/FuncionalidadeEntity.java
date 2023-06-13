package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Entity(name = "Funcionalidade")
@Table(name = "funcionalidade")
public class FuncionalidadeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String descricao;
}
