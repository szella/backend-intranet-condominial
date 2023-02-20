package br.com.szella.intranetcondominial.modal.repository;

import br.com.szella.intranetcondominial.modal.entity.UnidadeCondominoEntity;
import br.com.szella.intranetcondominial.modal.entity.UnidadeCondominoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeCondominoRepository extends JpaRepository<UnidadeCondominoEntity, UnidadeCondominoId> {
}
