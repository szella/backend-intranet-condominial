package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.mapper.AndarMapper;
import br.com.szella.intranetcondominial.repository.AndarRepository;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarEditarRequest;
import br.com.szella.intranetcondominial.service.AndarService;
import br.com.szella.intranetcondominial.service.PredioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@AllArgsConstructor
public class AndarServiceImpl implements AndarService {

    private AndarRepository repository;
    private PredioService predioService;

    @Override
    public List<AndarEntity> listar(Long pavimentoId) {
        try {
            return repository.findByPredioId(pavimentoId);
        } catch (Exception e) {
            log.error("### AndarServiceImpl.listar(): " + e);
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
    public List<AndarEntity> salvarAtualizar(Long predioId, List<AndarSalvarEditarRequest> request) {
        try {
            PredioEntity predioEntity = predioService.buscarPorId(predioId);

            List<AndarEntity> listaGravacao = new ArrayList<>();
            for (AndarSalvarEditarRequest andar : request) {
                listaGravacao.add(AndarMapper.mapEntity(predioEntity, andar));
            }

            List<AndarEntity> listaCompleta = repository.findByPredioId(predioId);

            for (AndarEntity andarRemocao : listaCompleta) {
                Boolean manter = listaGravacao.stream()
                        .filter(andarGravar -> andarRemocao.getId().equals(andarGravar.getId()))
                        .findFirst().isPresent();
                if (!manter) {
                    repository.delete(andarRemocao);
                }
            }

            repository.saveAll(listaGravacao);

            return listaGravacao;
        } catch (Exception e) {
            log.error("### AndarServiceImpl.salvarAtualizar(): " + e);
            throw new DBException(MensagemDeErroEnum.SALVAR.getMensagem());
        }
    }
}
