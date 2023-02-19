package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErro;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.mapper.AndarMapper;
import br.com.szella.intranetcondominial.modal.repository.AndarRepository;
import br.com.szella.intranetcondominial.modal.request.AndarEditarRequest;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarRequest;
import br.com.szella.intranetcondominial.service.AndarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AndarServiceImpl implements AndarService {

    private AndarRepository repository;

    @Override
    public List<AndarEntity> listar() {
        return repository.findAll();
    }

    @Override
    public AndarEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErro.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public AndarEntity salvar(AndarSalvarRequest request) {
        return repository.save(AndarMapper.mapEntity(request));
    }

    @Override
    public AndarEntity editar(Long id, AndarEditarRequest request) {
        var entity = buscarPorId(id);

        AndarMapper.mapAtualizacao(request, entity);
        repository.save(entity);
        return entity;
    }

    @Override
    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
