package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.PredioMapper;
import br.com.szella.intranetcondominial.modal.request.PredioEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PredioSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.PredioResponse;
import br.com.szella.intranetcondominial.modal.service.PredioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/predios")
@AllArgsConstructor
public class PredioController {
    private final PredioService service;

    @GetMapping
    public ResponseEntity<List<PredioResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(PredioMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PredioResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(PredioMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<PredioResponse> salvar(@RequestBody PredioSalvarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(PredioMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PredioResponse> editar(@PathVariable Long id, @RequestBody PredioEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(PredioMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
