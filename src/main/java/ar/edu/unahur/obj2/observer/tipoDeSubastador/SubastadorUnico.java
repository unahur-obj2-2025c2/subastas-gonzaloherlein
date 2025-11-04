package ar.edu.unahur.obj2.observer.tipoDeSubastador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public class SubastadorUnico implements TipoDeSubastador{

    private boolean yaOferto = false;

    @Override
    public Oferta realizarOferta(Subastador subastador) {
        yaOferto = true;
        return new Oferta(subastador, subastador.getUltimaOfertaRecibida().getValor() + 10);
    }

    @Override
    public Boolean puedeOfertar(Oferta ultimaOferta) {
        return !yaOferto;
    }

}
