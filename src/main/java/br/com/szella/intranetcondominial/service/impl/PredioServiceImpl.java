package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.mapper.PredioMapper;
import br.com.szella.intranetcondominial.repository.PredioRepository;
import br.com.szella.intranetcondominial.modal.request.PredioEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PredioSalvarRequest;
import br.com.szella.intranetcondominial.service.PredioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PredioServiceImpl implements PredioService {

    private PredioRepository repository;

    @Override
    public List<PredioEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public PredioEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public PredioEntity salvar(PredioSalvarRequest request) {
        try {
            return repository.save(PredioMapper.mapEntity(request));
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public PredioEntity editar(Long id, PredioEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            PredioMapper.mapAtualizacao(request, entity);

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
