package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.PavimentoEntity;
import br.com.szella.intranetcondominial.modal.request.PavimentoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PavimentoSalvarRequest;

import java.util.List;

public interface PavimentoService {
    List<PavimentoEntity> listar();

    PavimentoEntity buscarPorId(Long id);

    PavimentoEntity salvar(PavimentoSalvarRequest request);

    PavimentoEntity editar(Long id, PavimentoEditarRequest request);

    void deletar(Long id);
}
