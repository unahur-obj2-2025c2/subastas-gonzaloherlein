package ar.edu.unahur.obj2.observer.tipoDeSubastador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public class SubastadorArriesgado implements TipoDeSubastador{

    @Override
    public Oferta realizarOferta(Subastador subastador) {
        return new Oferta(subastador, subastador.getUltimaOfertaRecibida().getValor() + 10);
    }

    @Override
    public Boolean puedeOfertar(Oferta oferta) {
        return true;
    }

}
