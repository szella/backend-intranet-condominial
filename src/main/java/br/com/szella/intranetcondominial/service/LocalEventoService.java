package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.LocalEventoEntity;
import br.com.szella.intranetcondominial.modal.request.LocalEventoSalvarEditarRequest;

import java.util.List;

public interface LocalEventoService {
    List<LocalEventoEntity> listar();

    LocalEventoEntity buscarPorId(Long id);

    LocalEventoEntity salvar(LocalEventoSalvarEditarRequest request);

    LocalEventoEntity editar(Long id, LocalEventoSalvarEditarRequest request);

    void deletar(Long id);
}
