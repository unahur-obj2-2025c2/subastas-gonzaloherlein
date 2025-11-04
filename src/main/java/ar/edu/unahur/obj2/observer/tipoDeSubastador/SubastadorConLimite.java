package ar.edu.unahur.obj2.observer.tipoDeSubastador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public class SubastadorConLimite implements TipoDeSubastador{

    private final Double LIMITE;

    public SubastadorConLimite(Double lIMITE) {
        LIMITE = lIMITE;
    }

    @Override
    public Oferta realizarOferta(Subastador subastador) {
        return new Oferta(subastador, subastador.getUltimaOfertaRecibida().getValor() + 10);
    }

    @Override
    public Boolean puedeOfertar(Oferta oferta) {
        return oferta.getValor() <= LIMITE;
    }

}
