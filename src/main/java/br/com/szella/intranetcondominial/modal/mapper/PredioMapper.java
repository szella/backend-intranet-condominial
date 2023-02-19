package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.request.PredioEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PredioSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.PredioResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PredioMapper {
    public static PredioEntity mapEntity(PredioSalvarRequest request) {
        return PredioEntity.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .build();
    }

    public static void mapAtualizacao(PredioEditarRequest novo, PredioEntity atual) {
        atual.setNome(novo.getNome());
        atual.setDescricao(novo.getDescricao());
    }

    public static PredioResponse mapResponse(PredioEntity entity) {
        return PredioResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .build();
    }

    public static List<PredioResponse> mapListaResponse(List<PredioEntity> entities) {
        return entities.stream()
                .map(PredioMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
