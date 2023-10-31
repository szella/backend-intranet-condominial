package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.CargoMapper;
import br.com.szella.intranetcondominial.modal.request.CargoEditarRequest;
import br.com.szella.intranetcondominial.modal.request.CargoSalvarRequest;
import br.com.szella.intranetcondominial.modal.response.CargoResponse;
import br.com.szella.intranetcondominial.service.CargoService;
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
@RequestMapping("/v1/cargos")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class CargoController {
    private final CargoService service;

    @GetMapping
    public ResponseEntity<List<CargoResponse>> listar() {
        var entities = service.listar();
        return ResponseEntity.ok(CargoMapper.mapListaResponse(entities));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CargoResponse> buscarPorId(@PathVariable Long id) {
        var entity = Optional
                .ofNullable(service.buscarPorId(id))
                .filter(Objects::nonNull)
                .map(CargoMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<CargoResponse> salvar(@RequestBody CargoSalvarRequest request) {
        var entity = service.salvar(request);
        return ResponseEntity.ok(CargoMapper.mapResponse(entity));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CargoResponse> editar(@PathVariable Long id, @RequestBody CargoEditarRequest request) {
        var entity = service.editar(id, request);
        return ResponseEntity.ok(CargoMapper.mapResponse(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}
