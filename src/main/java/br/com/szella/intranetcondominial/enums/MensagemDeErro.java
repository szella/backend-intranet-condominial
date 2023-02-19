package br.com.szella.intranetcondominial.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagemDeErro {
    NAO_ENCONTRADO("Registro não localizado.");

    private String mensagem;
}
