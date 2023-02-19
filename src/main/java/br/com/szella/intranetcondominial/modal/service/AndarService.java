package br.com.szella.intranetcondominial.modal.service;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.request.AndarEditarRequest;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarRequest;

import java.util.List;

public interface AndarService {
    List<AndarEntity> listar();

    AndarEntity buscarPorId(Long id);

    AndarEntity salvar(AndarSalvarRequest request);

    AndarEntity editar(Long id, AndarEditarRequest request);

    void deletar(Long id);
}
