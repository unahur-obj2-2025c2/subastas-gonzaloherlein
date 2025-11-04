package ar.edu.unahur.obj2.observer.tipoDeSubastador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.Subastador;

public interface TipoDeSubastador {
    Oferta realizarOferta(Subastador subastador);
    Boolean puedeOfertar(Oferta oferta);
}
