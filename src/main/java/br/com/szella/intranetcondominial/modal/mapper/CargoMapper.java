package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.CargoEntity;
import br.com.szella.intranetcondominial.modal.request.CargoSalvarRequest;
import br.com.szella.intranetcondominial.modal.request.CargoEditarRequest;
import br.com.szella.intranetcondominial.modal.response.CargoResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CargoMapper {
    public static CargoEntity mapEntity(CargoSalvarRequest request) {
        return CargoEntity.builder()
                .nome(request.getNome())
                .build();
    }

    public static void mapAtualizacao(CargoEditarRequest novo, CargoEntity atual) {
        atual.setNome(novo.getNome());
    }

    public static CargoResponse mapResponse(CargoEntity entity) {
        return CargoResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }

    public static List<CargoResponse> mapListaResponse(List<CargoEntity> entities) {
        return entities.stream()
                .map(CargoMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
