package br.com.szella.intranetcondominial.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagemDeErroEnum {
    NAO_ENCONTRADO("Registro não localizado."),
    SALVAR("Erro ao salvar."),
    EDITAR("Erro ao editar."),
    DELETAR("Erro ao deletar."),
    LISTAR("Erro ao listar."),
    VINCULAR("Erro ao vincular."),
    DESVINCULAR("Erro ao desvincular."),
    EXISTE("Registro já existe");

    private String mensagem;
}
