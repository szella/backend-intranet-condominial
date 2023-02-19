package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.AndarMapper;
import br.com.szella.intranetcondominial.modal.request.AndarEditarRequest;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.AndarResponse;
import br.com.szella.intranetcondominial.modal.service.AndarService;
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
@RequestMapping("/andares")
@AllArgsConstructor
public class AndarController {
    private final AndarService service;

    @GetMapping
    public ResponseEntity<List<AndarResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(AndarMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AndarResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(AndarMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<AndarResponse> salvar(@RequestBody AndarSalvarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(AndarMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AndarResponse> editar(@PathVariable Long id, @RequestBody AndarEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(AndarMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
