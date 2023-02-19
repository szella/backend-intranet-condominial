package br.com.szella.intranetcondominial.modal.request;

import lombok.Data;

@Data
public class CondominoEditarRequest {
    private String nome;
    private String documento;
    private boolean proprietario;
}
