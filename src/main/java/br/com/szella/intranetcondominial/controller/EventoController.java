package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.EventoMapper;
import br.com.szella.intranetcondominial.modal.request.EventoSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.EventoResponse;
import br.com.szella.intranetcondominial.service.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class EventoController {
    private final EventoService service;

    @GetMapping
    public ResponseEntity<List<EventoResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(EventoMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(EventoMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<EventoResponse> salvar(@RequestBody EventoSalvarEditarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(EventoMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EventoResponse> editar(@PathVariable Long id, @RequestBody EventoSalvarEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(EventoMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
