package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.PavimentoEntity;
import br.com.szella.intranetcondominial.modal.request.PavimentoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PavimentoSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.PavimentoResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PavimentoMapper {
    public static PavimentoEntity mapEntity(PavimentoSalvarRequest request) {
        return PavimentoEntity.builder()
                .pavimento(request.getPavimento())
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .build();
    }

    public static void mapAtualizacao(PavimentoEditarRequest novo, PavimentoEntity atual) {
        atual.setPavimento(novo.getPavimento());
        atual.setNome(novo.getNome());
        atual.setDescricao(novo.getDescricao());
    }

    public static PavimentoResponse mapResponse(PavimentoEntity entity) {
        return PavimentoResponse.builder()
                .id(entity.getId())
                .pavimento(entity.getPavimento())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .build();
    }

    public static List<PavimentoResponse> mapListaResponse(List<PavimentoEntity> entities) {
        return entities.stream()
                .map(PavimentoMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
