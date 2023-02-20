package br.com.szella.intranetcondominial.modal.response;

import br.com.szella.intranetcondominial.enums.TipoCondominoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnidadeCondominoResponse {
    private UnidadeResponse unidade;
    private CondominoResponse condomino;
    private TipoCondominoEnum tipoCondomino;
}
