package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.CondominoEntity;
import br.com.szella.intranetcondominial.modal.mapper.CondominoMapper;
import br.com.szella.intranetcondominial.repository.CondominoRepository;
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
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public CondominoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public CondominoEntity salvar(CondominoSalvarRequest request) {
        try {
            return repository.save(CondominoMapper.mapEntity(request));
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public CondominoEntity editar(Long id, CondominoEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            CondominoMapper.mapAtualizacao(request, entity);

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
