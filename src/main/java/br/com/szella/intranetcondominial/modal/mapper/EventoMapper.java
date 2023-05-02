package br.com.szella.intranetcondominial.modal.mapper;

import br.com.szella.intranetcondominial.modal.entity.EventoEntity;
import br.com.szella.intranetcondominial.modal.request.EventoSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.EventoResponse;
import br.com.szella.intranetcondominial.modal.response.PredioResponse;

import java.util.List;
import java.util.stream.Collectors;

public class EventoMapper {

    public static EventoEntity mapEntity(EventoSalvarEditarRequest request) {
        return EventoEntity.builder()
                .data(request.getData())
                .locatario(request.getLocatario())
                .periodo(request.getPeriodo())
                .dataInicio(request.getDataInicio())
                .dataFim(request.getDataFim())
                .observacao(request.getObservacao())
                .build();
    }

    public static void mapAtualizacao(EventoSalvarEditarRequest novo, EventoEntity atual) {
        atual.setData(novo.getData());
        atual.setLocatario(novo.getLocatario());
        atual.setPeriodo(novo.getPeriodo());
        atual.setDataInicio(novo.getDataInicio());
        atual.setDataFim(novo.getDataFim());
        atual.setObservacao(novo.getObservacao());
    }

    public static EventoResponse mapResponse(EventoEntity entity) {
        return EventoResponse.builder()
                .id(entity.getId())
                .localEvento(LocalEventoMapper.mapResponse(entity.getLocalEvento()))
                .data(entity.getData())
                .locatario(entity.getLocatario())
                .periodo(entity.getPeriodo())
                .dataInicio(entity.getDataInicio())
                .dataFim(entity.getDataFim())
                .observacao(entity.getObservacao())
                .build();
    }

    public static List<EventoResponse> mapListaResponse(List<EventoEntity> entities) {
        return entities.stream()
                .map(EventoMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
