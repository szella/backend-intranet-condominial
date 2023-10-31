package br.com.szella.intranetcondominial.modal.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CargoResponse {
    private Long id;
    private String nome;
}
