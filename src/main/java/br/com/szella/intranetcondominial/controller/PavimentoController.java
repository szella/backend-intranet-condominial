package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.PavimentoMapper;
import br.com.szella.intranetcondominial.modal.request.PavimentoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.PavimentoSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.PavimentoResponse;
import br.com.szella.intranetcondominial.modal.service.PavimentoService;
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
@RequestMapping("/pavimentos")
@AllArgsConstructor
public class PavimentoController {
    private final PavimentoService service;

    @GetMapping
    public ResponseEntity<List<PavimentoResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(PavimentoMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PavimentoResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(PavimentoMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<PavimentoResponse> salvar(@RequestBody PavimentoSalvarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(PavimentoMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PavimentoResponse> editar(@PathVariable Long id, @RequestBody PavimentoEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(PavimentoMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
