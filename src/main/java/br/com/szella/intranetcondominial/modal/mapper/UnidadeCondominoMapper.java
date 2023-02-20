package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.UnidadeCondominoEntity;
import br.com.szella.intranetcondominial.modal.response.UnidadeCondominoResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnidadeCondominoMapper {
    public static UnidadeCondominoResponse mapResponse(UnidadeCondominoEntity entity) {
        return UnidadeCondominoResponse.builder()
                .unidade(UnidadeMapper.mapResponse(entity.getUnidade()))
                .condomino(CondominoMapper.mapResponse(entity.getCondomino()))
                .tipoCondomino(entity.getTipoCondomino())
                .build();
    }
}
