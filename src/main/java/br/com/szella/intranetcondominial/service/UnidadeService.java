package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarEditarRequest;

import java.util.List;

public interface UnidadeService {
    List<UnidadeEntity> listar(Long andarId);

    UnidadeEntity buscarPorId(Long id);

    List<UnidadeEntity> salvarAtualizar(Long andarId, List<UnidadeSalvarEditarRequest> request);

}
