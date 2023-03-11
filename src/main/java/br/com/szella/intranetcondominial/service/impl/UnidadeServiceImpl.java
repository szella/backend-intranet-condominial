package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.mapper.UnidadeMapper;
import br.com.szella.intranetcondominial.modal.repository.UnidadeRepository;
import br.com.szella.intranetcondominial.modal.request.UnidadeEditarRequest;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarRequest;
import br.com.szella.intranetcondominial.service.AndarService;
import br.com.szella.intranetcondominial.service.UnidadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnidadeServiceImpl implements UnidadeService {

    private UnidadeRepository repository;

    private AndarService andarService;

    @Override
    public List<UnidadeEntity> listar(Long andarId) {
        try {
            return repository.findByAndarId(andarId);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.LISTAR.getMensagem());
        }
    }

    @Override
    public UnidadeEntity buscarPorId(Long id) {
        return Optional
                .of(repository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));
    }

    @Override
    public UnidadeEntity salvar(UnidadeSalvarRequest request) {
        try {
            var entity = UnidadeMapper.mapEntity(request);
            entity.setAndar(andarService.buscarPorId(request.getAndarId()));

            return repository.save(entity);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }

    @Override
    public UnidadeEntity editar(Long id, UnidadeEditarRequest request) {
        try {
            var entity = buscarPorId(id);

            UnidadeMapper.mapAtualizacao(request, entity);

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
