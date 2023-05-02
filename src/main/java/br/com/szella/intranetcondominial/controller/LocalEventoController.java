package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.LocalEventoMapper;
import br.com.szella.intranetcondominial.modal.request.LocalEventoSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.LocalEventoResponse;
import br.com.szella.intranetcondominial.service.LocalEventoService;
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
@RequestMapping("/v1/locais-evento")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class LocalEventoController {
    private final LocalEventoService service;

    @GetMapping
    public ResponseEntity<List<LocalEventoResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(LocalEventoMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocalEventoResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(LocalEventoMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<LocalEventoResponse> salvar(@RequestBody LocalEventoSalvarEditarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(LocalEventoMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LocalEventoResponse> editar(@PathVariable Long id, @RequestBody LocalEventoSalvarEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(LocalEventoMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
