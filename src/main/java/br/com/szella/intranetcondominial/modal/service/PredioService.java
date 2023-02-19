package br.com.szella.intranetcondominial.modal.service;

import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.request.PredioEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PredioSalvarRequest;

import java.util.List;

public interface PredioService {
    List<PredioEntity> listar();

    PredioEntity buscarPorId(Long id);

    PredioEntity salvar(PredioSalvarRequest request);

    PredioEntity editar(Long id, PredioEditarRequest request);

    void deletar(Long id);
}
