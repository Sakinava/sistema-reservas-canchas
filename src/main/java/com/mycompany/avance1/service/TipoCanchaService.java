package com.mycompany.avance1.service;

import com.mycompany.avance1.model.TipoCancha;
import java.util.List;

public interface TipoCanchaService {

    List<TipoCancha> getTiposCancha();

    TipoCancha getTipoCancha(Long id);

    void save(TipoCancha tipoCancha);

    void delete(TipoCancha tipoCancha);
}