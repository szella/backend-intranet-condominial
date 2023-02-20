package br.com.szella.intranetcondominial.service.impl;

import br.com.szella.intranetcondominial.enums.MensagemDeErroEnum;
import br.com.szella.intranetcondominial.exception.DBException;
import br.com.szella.intranetcondominial.modal.entity.UnidadeCondominoEntity;
import br.com.szella.intranetcondominial.modal.entity.UnidadeCondominoId;
import br.com.szella.intranetcondominial.modal.repository.UnidadeCondominoRepository;
import br.com.szella.intranetcondominial.modal.request.UnidadeCondominoDesvincularResquest;
import br.com.szella.intranetcondominial.modal.request.UnidadeCondominoVincularResquest;
import br.com.szella.intranetcondominial.service.CondominoService;
import br.com.szella.intranetcondominial.service.UnidadeCondominoService;
import br.com.szella.intranetcondominial.service.UnidadeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UnidadeCondominoServiceImpl implements UnidadeCondominoService {

    private UnidadeCondominoRepository repository;
    private UnidadeService unidadeService;
    private CondominoService condominoService;

    @Override
    public UnidadeCondominoEntity vincular(UnidadeCondominoVincularResquest resquest) {
        buscarPorId(resquest.getUnidadeId(), resquest.getCondominoId())
                .ifPresent(entity -> {
                    throw new DBException(MensagemDeErroEnum.EXISTE.getMensagem());
                });

        try {
            var unidade = unidadeService.buscarPorId(resquest.getUnidadeId());
            var condomino = condominoService.buscarPorId(resquest.getCondominoId());

            var unidadeCondominoId = new UnidadeCondominoId(unidade.getId(), condomino.getId());
            var unidadeCondomino = UnidadeCondominoEntity.builder()
                    .id(unidadeCondominoId)
                    .unidade(unidade)
                    .condomino(condomino)
                    .tipoCondomino(resquest.getTipoCondomino())
                    .build();

            return repository.save(unidadeCondomino);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.VINCULAR.getMensagem());
        }
    }

    @Override
    public void desvincular(UnidadeCondominoDesvincularResquest resquest) {
        try {
            var entity = buscarPorId(resquest.getUnidadeId(), resquest.getCondominoId())
                    .orElseThrow(() -> new DBException(MensagemDeErroEnum.NAO_ENCONTRADO.getMensagem()));

            repository.delete(entity);
        } catch (Exception e) {
            throw new DBException(MensagemDeErroEnum.DESVINCULAR.getMensagem());
        }
    }

    private Optional<UnidadeCondominoEntity> buscarPorId(Long unidadeId, Long condominoId) {
        var unidadeCondominoId = new UnidadeCondominoId(unidadeId, condominoId);

        return repository.findById(unidadeCondominoId);
    }
}
