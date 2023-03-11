package br.com.szella.intranetcondominial.modal.repository;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AndarRepository extends JpaRepository<AndarEntity, Long> {


    @Query(value = "SELECT a FROM Andar a" +
            " WHERE :predioId IS NULL or a.predio.id = :predioId" +
            " ORDER BY a.posicao ASC")
    List<AndarEntity> findByPredioId(@Param("predioId") Long predioId);
}
