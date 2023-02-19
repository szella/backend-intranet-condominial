package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.PavimentoEntity;
import br.com.szella.intranetcondominial.modal.mapper.PavimentoMapper;
import br.com.szella.intranetcondominial.modal.repository.PavimentoRepository;
import br.com.szella.intranetcondominial.modal.request.PavimentoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PavimentoSalvarRequest;
import br.com.szella.intranetcondominial.service.PavimentoService;
import br.com.szella.intranetcondominial.service.PredioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PavimentoServiceImpl implements PavimentoService {

    private PavimentoRepository repository;

    private PredioService predioService;

    @Override
    public List<PavimentoEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public PavimentoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public PavimentoEntity salvar(PavimentoSalvarRequest request) {
        try {
            var entity = PavimentoMapper.mapEntity(request);
            entity.setPredio(predioService.buscarPorId(request.getPredioId()));

            return repository.save(entity);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public PavimentoEntity editar(Long id, PavimentoEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            PavimentoMapper.mapAtualizacao(request, entity);
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
