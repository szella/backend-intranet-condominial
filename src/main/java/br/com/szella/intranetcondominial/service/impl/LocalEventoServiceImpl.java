package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.LocalEventoEntity;
import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.mapper.LocalEventoMapper;
import br.com.szella.intranetcondominial.repository.LocalEventoRepository;
import br.com.szella.intranetcondominial.modal.request.LocalEventoSalvarEditarRequest;
import br.com.szella.intranetcondominial.service.LocalEventoService;
import br.com.szella.intranetcondominial.service.PredioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocalEventoServiceImpl implements LocalEventoService {

    private LocalEventoRepository repository;

    private PredioService predioService;

    @Override
    public List<LocalEventoEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public LocalEventoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));

    }

    @Override
    public LocalEventoEntity salvar(LocalEventoSalvarEditarRequest request) {
        try {
            LocalEventoEntity entity=LocalEventoMapper.mapEntity(request);

            PredioEntity predio = predioService.buscarPorId(request.getPredioId());
            entity.setPredio(predio);

            return repository.save(entity);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public LocalEventoEntity editar(Long id, LocalEventoSalvarEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            LocalEventoMapper.mapAtualizacao(request, entity);

            if (!request.getPredioId().equals(entity.getPredio().getId())) {
                PredioEntity predio = predioService.buscarPorId(request.getPredioId());
                entity.setPredio(predio);
            }

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
