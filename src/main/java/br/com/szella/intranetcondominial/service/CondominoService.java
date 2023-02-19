package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.CondominoEntity;
import br.com.szella.intranetcondominial.modal.request.CondominoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CondominoSalvarRequest;

import java.util.List;

public interface CondominoService {
    List<CondominoEntity> listar();

    CondominoEntity buscarPorId(Long id);

    CondominoEntity salvar(CondominoSalvarRequest request);

    CondominoEntity editar(Long id, CondominoEditarRequest request);

    void deletar(Long id);
}
