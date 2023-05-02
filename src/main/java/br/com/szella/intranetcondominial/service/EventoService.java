package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.EventoEntity;
import br.com.szella.intranetcondominial.modal.request.EventoSalvarEditarRequest;

import java.util.List;

public interface EventoService {
    List<EventoEntity> listar();

    EventoEntity buscarPorId(Long id);

    EventoEntity salvar(EventoSalvarEditarRequest request);

    EventoEntity editar(Long id, EventoSalvarEditarRequest request);

    void deletar(Long id);
}
