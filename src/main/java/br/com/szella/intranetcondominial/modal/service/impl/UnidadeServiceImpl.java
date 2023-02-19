package br.com.szella.intranetcondominial.modal.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErro;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.mapper.UnidadeMapper;
import br.com.szella.intranetcondominial.modal.repository.UnidadeRepository;
import br.com.szella.intranetcondominial.modal.request.UnidadeEditarRequest;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarRequest;
import br.com.szella.intranetcondominial.modal.service.UnidadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnidadeServiceImpl implements UnidadeService {

    private UnidadeRepository repository;

    @Override
    public List<UnidadeEntity> listar() {
        return repository.findAll();
    }

    @Override
    public UnidadeEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErro.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public UnidadeEntity salvar(UnidadeSalvarRequest request) {
        return repository.save(UnidadeMapper.mapEntity(request));
    }

    @Override
    public UnidadeEntity editar(Long id, UnidadeEditarRequest request) {
        var entity = buscarPorId(id);

        UnidadeMapper.mapAtualizacao(request, entity);
        repository.save(entity);
        return entity;
    }

    @Override
    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
