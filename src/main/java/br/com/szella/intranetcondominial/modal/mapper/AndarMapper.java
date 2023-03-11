package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.entity.PredioEntity;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.AndarResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class AndarMapper {
    public static AndarEntity mapEntity(PredioEntity predio, AndarSalvarEditarRequest request) {
        return AndarEntity.builder()
                .id(request.getId())
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .predio(predio)
                .posicao(request.getPosicao())
                .build();
    }

    public static AndarResponse mapResponse(AndarEntity entity) {
        return AndarResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .posicao(entity.getPosicao())
                .build();
    }

    public static List<AndarResponse> mapListaResponse(List<AndarEntity> entities) {
        return entities.stream()
                .map(AndarMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
