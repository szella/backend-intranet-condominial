package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.UnidadeResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UnidadeMapper {
    public static UnidadeEntity mapEntity(AndarEntity andar, UnidadeSalvarEditarRequest request) {
        return UnidadeEntity.builder()
                .id(request.getId())
                .descricao(request.getNome())
                .andar(andar)
                .build();
    }

    public static UnidadeResponse mapResponse(UnidadeEntity entity) {
        return UnidadeResponse.builder()
                .id(entity.getId())
                .nome(entity.getDescricao())
                .build();
    }

    public static List<UnidadeResponse> mapListaResponse(List<UnidadeEntity> entities) {
        return entities.stream()
                .map(UnidadeMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
