package br.com.szella.intranetcondominial.service;

import br.com.szella.intranetcondominial.modal.entity.UnidadeCondominoEntity;
import br.com.szella.intranetcondominial.modal.request.UnidadeCondominoDesvincularResquest;
import br.com.szella.intranetcondominial.modal.request.UnidadeCondominoVincularResquest;

public interface UnidadeCondominoService {
    UnidadeCondominoEntity vincular(UnidadeCondominoVincularResquest resquest);

    void desvincular(UnidadeCondominoDesvincularResquest resquest);
}
