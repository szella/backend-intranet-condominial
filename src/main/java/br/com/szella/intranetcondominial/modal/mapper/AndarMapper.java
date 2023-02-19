package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.AndarEntity;
import br.com.szella.intranetcondominial.modal.request.AndarEditarRequest;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.AndarResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class AndarMapper {
    public static AndarEntity mapEntity(AndarSalvarRequest request) {
        return AndarEntity.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .build();
    }

    public static void mapAtualizacao(AndarEditarRequest novo, AndarEntity atual) {
        atual.setNome(novo.getNome());
        atual.setDescricao(novo.getDescricao());
    }

    public static AndarResponse mapResponse(AndarEntity entity) {
        return AndarResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .build();
    }

    public static List<AndarResponse> mapListaResponse(List<AndarEntity> entities) {
        return entities.stream()
                .map(AndarMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
