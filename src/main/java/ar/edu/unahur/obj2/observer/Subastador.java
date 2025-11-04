package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.tipoDeSubastador.TipoDeSubastador;

public class Subastador implements IObservador{

    private String nombreDeUsuario;
    private Oferta ultimaOfertaRecibida;
    private TipoDeSubastador tipo;

    public Subastador(String nombreDeUsuario, Oferta ultimaOfertaRecibida) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.ultimaOfertaRecibida = ultimaOfertaRecibida;
    }

    @Override
    public void actualizar(Oferta oferta) {
        ultimaOfertaRecibida = oferta;
    }

    public Oferta realizarOfertaSegunTipo(){
        if(!tipo.puedeOfertar(ultimaOfertaRecibida)){
            throw new NoSePuedeOfertarException("No se puede realizar la oferta según la estrategia actual");
        }
        return tipo.realizarOferta(this);
    }

    public void reiniciarUltimaOferta(){
        ultimaOfertaRecibida = null;
    }

    public Oferta getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }

    public void setUltimaOfertaRecibida(Oferta ultimaOfertaRecibida) {
        this.ultimaOfertaRecibida = ultimaOfertaRecibida;
    }

    
}
