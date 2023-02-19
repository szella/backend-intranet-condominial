package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.mapper.AndarMapper;
import br.com.szella.intranetcondominial.modal.repository.AndarRepository;
import br.com.szella.intranetcondominial.modal.request.AndarEditarRequest;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarRequest;
import br.com.szella.intranetcondominial.service.AndarService;
import br.com.szella.intranetcondominial.service.PavimentoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AndarServiceImpl implements AndarService {

    private AndarRepository repository;
    private PavimentoService pavimentoService;

    @Override
    public List<AndarEntity> listar() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public AndarEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public AndarEntity salvar(AndarSalvarRequest request) {
        try {
            var entity = AndarMapper.mapEntity(request);
            entity.setPavimento(pavimentoService.buscarPorId(request.getPavimentoId()));

            return repository.save(entity);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public AndarEntity editar(Long id, AndarEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            AndarMapper.mapAtualizacao(request, entity);

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
