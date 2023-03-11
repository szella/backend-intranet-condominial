package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.request.UnidadeEditarRequest;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarRequest;

import java.util.List;

public interface UnidadeService {
    List<UnidadeEntity> listar(Long andarId);

    UnidadeEntity buscarPorId(Long id);

    UnidadeEntity salvar(UnidadeSalvarRequest request);

    UnidadeEntity editar(Long id, UnidadeEditarRequest request);

    void deletar(Long id);
}
