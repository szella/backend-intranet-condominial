package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErro;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.CondominoEntity;
import br.com.szella.intranetcondominial.modal.mapper.CondominoMapper;
import br.com.szella.intranetcondominial.modal.repository.CondominoRepository;
import br.com.szella.intranetcondominial.modal.request.CondominoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CondominoSalvarRequest;
import br.com.szella.intranetcondominial.service.CondominoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CondominoServiceImpl implements CondominoService {

    private CondominoRepository repository;

    @Override
    public List<CondominoEntity> listar() {
        return repository.findAll();
    }

    @Override
    public CondominoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErro.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public CondominoEntity salvar(CondominoSalvarRequest request) {
        return repository.save(CondominoMapper.mapEntity(request));
    }

    @Override
    public CondominoEntity editar(Long id, CondominoEditarRequest request) {
        var entity = buscarPorId(id);

        CondominoMapper.mapAtualizacao(request, entity);
        repository.save(entity);
        return entity;
    }

    @Override
    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
