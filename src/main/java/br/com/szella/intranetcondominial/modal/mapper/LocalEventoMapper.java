package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.LocalEventoEntity;
import br.com.szella.intranetcondominial.modal.request.LocalEventoSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.LocalEventoResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class LocalEventoMapper {

    public static LocalEventoEntity mapEntity(LocalEventoSalvarEditarRequest request) {
        return LocalEventoEntity.builder()
                .nome(request.getNome())
                .valor(request.getValor())
                .build();
    }

    public static void mapAtualizacao(LocalEventoSalvarEditarRequest novo, LocalEventoEntity atual) {
        atual.setNome(novo.getNome());
        atual.setValor(novo.getValor());
    }

    public static LocalEventoResponse mapResponse(LocalEventoEntity entity) {
        return LocalEventoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .valor(entity.getValor())
                .predio(PredioMapper.mapResponse(entity.getPredio()))
                .build();
    }

    public static List<LocalEventoResponse> mapListaResponse(List<LocalEventoEntity> entities) {
        return entities.stream()
                .map(LocalEventoMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
