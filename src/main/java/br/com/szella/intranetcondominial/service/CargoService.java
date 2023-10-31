package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.entity.CargoEntity;
import br.com.szella.intranetcondominial.modal.entity.CargoEntity;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CargoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CargoSalvarRequest;

import java.util.List;

public interface CargoService {
    List<CargoEntity> listar();

    CargoEntity buscarPorId(Long id);

    CargoEntity salvar(CargoSalvarRequest request);

    CargoEntity editar(Long id, CargoEditarRequest request);

    void deletar(Long id);
}
