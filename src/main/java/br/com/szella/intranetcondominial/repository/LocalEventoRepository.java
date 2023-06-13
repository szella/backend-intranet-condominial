package br.com.szella.intranetcondominial.repository;

import br.com.szella.intranetcondominial.modal.entity.LocalEventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalEventoRepository extends JpaRepository<LocalEventoEntity, Long> {
}
