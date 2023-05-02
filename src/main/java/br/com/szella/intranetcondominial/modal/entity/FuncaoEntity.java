package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Funcao")
@Table(name = "funcao")
public class FuncaoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;
}
