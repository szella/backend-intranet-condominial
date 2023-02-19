package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErro;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.PavimentoEntity;
import br.com.szella.intranetcondominial.modal.mapper.PavimentoMapper;
import br.com.szella.intranetcondominial.modal.repository.PavimentoRepository;
import br.com.szella.intranetcondominial.modal.request.PavimentoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PavimentoSalvarRequest;
import br.com.szella.intranetcondominial.service.PavimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PavimentoServiceImpl implements PavimentoService {

    private PavimentoRepository repository;

    @Override
    public List<PavimentoEntity> listar() {
        return repository.findAll();
    }

    @Override
    public PavimentoEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErro.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public PavimentoEntity salvar(PavimentoSalvarRequest request) {
        return repository.save(PavimentoMapper.mapEntity(request));
    }

    @Override
    public PavimentoEntity editar(Long id, PavimentoEditarRequest request) {
        var entity = buscarPorId(id);

        PavimentoMapper.mapAtualizacao(request, entity);
        repository.save(entity);
        return entity;
    }

    @Override
    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
