package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class CondominoSalvarRequest {
    private String nome;
    private String documento;
    private boolean proprietario;
}
