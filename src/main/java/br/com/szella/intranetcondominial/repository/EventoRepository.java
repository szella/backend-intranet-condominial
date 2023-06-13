package br.com.szella.intranetcondominial.repository;

import br.com.szella.intranetcondominial.modal.entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}
