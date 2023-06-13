package br.com.szella.intranetcondominial.modal.entity;

import jakarta.persistence.Column;
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
@Entity(name = "Cargo")
@Table(name = "cargo")
public class CargoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;
}
