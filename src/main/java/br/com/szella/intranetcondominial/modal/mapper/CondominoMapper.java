package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.CondominoEntity;
import br.com.szella.intranetcondominial.modal.request.CondominoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CondominoSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.CondominoResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CondominoMapper {
    public static CondominoEntity mapEntity(CondominoSalvarRequest request) {
        return CondominoEntity.builder()
                .nome(request.getNome())
                .documento(request.getDocumento())
                .build();
    }

    public static void mapAtualizacao(CondominoEditarRequest novo, CondominoEntity atual) {
        atual.setNome(novo.getNome());
        atual.setDocumento(novo.getDocumento());
    }

    public static CondominoResponse mapResponse(CondominoEntity entity) {
        return CondominoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .documento(entity.getDocumento())
                .build();
    }

    public static List<CondominoResponse> mapListaResponse(List<CondominoEntity> entities) {
        return entities.stream()
                .map(CondominoMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
