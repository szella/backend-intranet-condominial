package br.com.szella.intranetcondominial.repository;

import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UnidadeRepository extends JpaRepository<UnidadeEntity, Long> {

    @Query(value = "SELECT u FROM Unidade u" +
            " WHERE :andarId IS NULL or u.andar.id = :andarId" +
            " ORDER BY u.descricao ASC")
    List<UnidadeEntity> findByAndarId(@Param("andarId") Long andarId);
}
