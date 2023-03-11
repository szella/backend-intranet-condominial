package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.AndarMapper;
import br.com.szella.intranetcondominial.modal.request.AndarSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.AndarResponse;
import br.com.szella.intranetcondominial.service.AndarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/andares")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class AndarController {
    private final AndarService service;

    @GetMapping
    public ResponseEntity<List<AndarResponse>> listar(@RequestParam(required = false) Long predioId) {
        var entities = service.listar(predioId);
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

    @PostMapping("/{predioId}")
    public ResponseEntity<List<AndarResponse>> salvarAtualizar(
            @PathVariable Long predioId, @RequestBody List<AndarSalvarEditarRequest> request) {
        var entities = service.salvarAtualizar(predioId, request);
        return ResponseEntity.ok(AndarMapper.mapListaResponse(entities));
    }
}
