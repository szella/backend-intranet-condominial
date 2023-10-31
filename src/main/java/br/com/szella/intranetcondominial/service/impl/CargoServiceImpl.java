package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.CargoEntity;
import br.com.szella.intranetcondominial.modal.mapper.CargoMapper;
import br.com.szella.intranetcondominial.modal.request.CargoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CargoSalvarRequest;
import br.com.szella.intranetcondominial.repository.CargoRepository;
import br.com.szella.intranetcondominial.service.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoServiceImpl implements CargoService {

    private CargoRepository repository;

    @Override
    public List<CargoEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public CargoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public CargoEntity salvar(CargoSalvarRequest request) {
        try {
            return repository.save(CargoMapper.mapEntity(request));
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public CargoEntity editar(Long id, CargoEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            CargoMapper.mapAtualizacao(request, entity);

            repository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.EDITAR.getMensagem());
        }
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.delete(buscarPorId(id));
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.DELETAR.getMensagem());
        }
    }
}
