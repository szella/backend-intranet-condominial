package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.EventoEntity;
import br.com.szella.intranetcondominial.modal.entity.LocalEventoEntity;
import br.com.szella.intranetcondominial.modal.mapper.EventoMapper;
import br.com.szella.intranetcondominial.modal.repository.EventoRepository;
import br.com.szella.intranetcondominial.modal.request.EventoSalvarEditarRequest;
import br.com.szella.intranetcondominial.service.EventoService;
import br.com.szella.intranetcondominial.service.LocalEventoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventoServiceImpl implements EventoService {

    private final EventoRepository repository;
    private final LocalEventoService localEventoService;

    @Override
    public List<EventoEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public EventoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public EventoEntity salvar(EventoSalvarEditarRequest request) {
        try {
            EventoEntity entity = EventoMapper.mapEntity(request);

            LocalEventoEntity localEventoEntity = localEventoService.buscarPorId(request.getLocalEventoId());
            entity.setLocalEvento(localEventoEntity);

            return repository.save(entity);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public EventoEntity editar(Long id, EventoSalvarEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            EventoMapper.mapAtualizacao(request, entity);

            if (!entity.getLocalEvento().getId().equals(request.getLocalEventoId())) {
                LocalEventoEntity localEventoEntity = localEventoService.buscarPorId(request.getLocalEventoId());
                entity.setLocalEvento(localEventoEntity);
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
