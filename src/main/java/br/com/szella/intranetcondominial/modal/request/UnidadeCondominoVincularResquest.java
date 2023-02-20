package br.com.szella.intranetcondominial.modal.request;

import br.com.szella.intranetcondominial.enums.TipoCondominoEnum;
import lombok.Data;

@Data
public class UnidadeCondominoVincularResquest {
    private Long unidadeId;
    private Long condominoId;
    private TipoCondominoEnum tipoCondomino;
}
