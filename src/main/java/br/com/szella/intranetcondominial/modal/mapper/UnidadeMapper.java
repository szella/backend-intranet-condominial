package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.UnidadeEntity;
import br.com.szella.intranetcondominial.modal.request.UnidadeEditarRequest;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.UnidadeResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UnidadeMapper {
    public static UnidadeEntity mapEntity(UnidadeSalvarRequest request) {
        return UnidadeEntity.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .build();
    }

    public static void mapAtualizacao(UnidadeEditarRequest novo, UnidadeEntity atual) {
        atual.setNome(novo.getNome());
        atual.setDescricao(novo.getDescricao());
    }

    public static UnidadeResponse mapResponse(UnidadeEntity entity) {
        return UnidadeResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .build();
    }

    public static List<UnidadeResponse> mapListaResponse(List<UnidadeEntity> entities) {
        return entities.stream()
                .map(UnidadeMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
