package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.UnidadeMapper;
import br.com.szella.intranetcondominial.modal.request.UnidadeEditarRequest;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.UnidadeResponse;
import br.com.szella.intranetcondominial.modal.service.UnidadeService;
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
@RequestMapping("/Unidade")
@AllArgsConstructor
public class UnidadeController {
    private final UnidadeService service;

    @GetMapping
    public ResponseEntity<List<UnidadeResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(UnidadeMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(UnidadeMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<UnidadeResponse> salvar(@RequestBody UnidadeSalvarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(UnidadeMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UnidadeResponse> editar(@PathVariable Long id, @RequestBody UnidadeEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(UnidadeMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
