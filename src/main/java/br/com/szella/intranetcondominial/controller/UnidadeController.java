package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.UnidadeMapper;
import br.com.szella.intranetcondominial.modal.request.UnidadeSalvarEditarRequest;
import br.com.szella.intranetcondominial.modal.response.UnidadeResponse;
import br.com.szella.intranetcondominial.service.UnidadeService;
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

@RestController
@RequestMapping("/unidades")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class UnidadeController {
    private final UnidadeService service;

    @GetMapping
    public ResponseEntity<List<UnidadeResponse>> listar(@RequestParam(required = false) Long andarId) {
        var entities = service.listar(andarId);
        return ResponseEntity.ok(UnidadeMapper.mapListaResponse(entities));
    }

    @PostMapping("/{andarId}")
    public ResponseEntity<List<UnidadeResponse>> salvarAtualizar(
            @PathVariable Long andarId, @RequestBody List<UnidadeSalvarEditarRequest> request) {
        var entity = service.salvarAtualizar(andarId, request);
        return ResponseEntity.ok(UnidadeMapper.mapListaResponse(entity));
    }
}
