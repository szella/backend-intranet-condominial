package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarEditarRequest;

import java.util.List;

public interface AndarService {
    List<AndarEntity> listar(Long predioId);

    AndarEntity buscarPorId(Long id);

    List<AndarEntity> salvarAtualizar(Long predioId, List<AndarSalvarEditarRequest> request);
}
