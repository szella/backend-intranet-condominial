package br.com.szella.intranetcondominial.modal.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErro;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.mapper.PredioMapper;
import br.com.szella.intranetcondominial.modal.repository.PredioRepository;
import br.com.szella.intranetcondominial.modal.request.PredioEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PredioSalvarRequest;
import br.com.szella.intranetcondominial.modal.service.PredioService;
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
        return repository.findAll();
    }

    @Override
    public PredioEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErro.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public PredioEntity salvar(PredioSalvarRequest request) {
        return repository.save(PredioMapper.mapEntity(request));
    }

    @Override
    public PredioEntity editar(Long id, PredioEditarRequest request) {
        var entity = buscarPorId(id);

        PredioMapper.mapAtualizacao(request, entity);
        repository.save(entity);
        return entity;
    }

    @Override
    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
