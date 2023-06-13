package br.com.szella.intranetcondominial.repository;

import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PredioRepository extends JpaRepository<PredioEntity, Long> , JpaSpecificationExecutor<PredioEntity> {
}
