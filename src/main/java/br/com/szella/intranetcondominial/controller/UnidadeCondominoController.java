package br.com.szella.intranetcondominial.controller;

import br.com.szella.intranetcondominial.modal.mapper.UnidadeCondominoMapper;
import br.com.szella.intranetcondominial.modal.request.UnidadeCondominoDesvincularResquest;
import br.com.szella.intranetcondominial.modal.request.UnidadeCondominoVincularResquest;
import br.com.szella.intranetcondominial.modal.response.UnidadeCondominoResponse;
import br.com.szella.intranetcondominial.service.UnidadeCondominoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/unidades-condominos")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class UnidadeCondominoController {
    private final UnidadeCondominoService service;

    @PostMapping(value = "/vincular")
    public ResponseEntity<UnidadeCondominoResponse> vincular(@RequestBody UnidadeCondominoVincularResquest request) {
        var entity = service.vincular(request);
        return ResponseEntity.ok(UnidadeCondominoMapper.mapResponse(entity));
    }

    @PostMapping(value = "/desvincular")
    public ResponseEntity<Void> desvincular(@RequestBody UnidadeCondominoDesvincularResquest request) {
        service.desvincular(request);
        return ResponseEntity.ok().build();
    }
}
