package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.mapper.UnidadeMapper;
import br.com.szella.intranetcondominial.repository.UnidadeRepository;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarEditarRequest;
import br.com.szella.intranetcondominial.service.AndarService;
import br.com.szella.intranetcondominial.service.UnidadeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    public List<UnidadeEntity> salvarAtualizar(Long andarId, List<UnidadeSalvarEditarRequest> request) {
        try {
            AndarEntity andarEntity = andarService.buscarPorId(andarId);

            List<UnidadeEntity> listaGravacao = new ArrayList<>();
            for (UnidadeSalvarEditarRequest unidade : request) {
                listaGravacao.add(UnidadeMapper.mapEntity(andarEntity, unidade));
            }

            List<UnidadeEntity> listaCompleta = repository.findByAndarId(andarId);

            for (UnidadeEntity undidadeRemocao : listaCompleta) {
                Boolean manter = listaGravacao.stream()
                        .filter(unidadeGravar -> unidadeGravar.getId().equals(undidadeRemocao.getId()))
                        .findFirst().isPresent();
                if (!manter) {
                    repository.delete(undidadeRemocao);
                }
            }

            repository.saveAll(listaGravacao);

            return listaGravacao;
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.EDITAR.getMensagem());
        }
    }
}
