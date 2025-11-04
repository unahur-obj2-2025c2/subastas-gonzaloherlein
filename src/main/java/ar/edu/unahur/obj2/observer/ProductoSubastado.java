package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoSubastado implements Observable{

    private List<Oferta> ofertasRecibidas = new ArrayList<>();
    private Set<IObservador> subastadores = new HashSet<>();



    @Override
    public void agregarObservador(IObservador observador) {
        subastadores.add(observador);
    }

    @Override
    public void quitarObservador(IObservador observador) {
        subastadores.remove(observador);
    }

    @Override
    public void notificar(Oferta oferta) {
        subastadores.forEach(s -> s.actualizar(oferta));
    }

    public void recibirOferta(Subastador subastador){
        if(!subastadores.contains(subastador)){
            throw new SubastadorNoParticipaEnLaSubastaException("El subastador no participa en la subasta");
        }
        Oferta oferta = subastador.realizarOfertaSegunTipo();
        ofertasRecibidas.add(oferta);
        this.notificar(oferta);
    }

    public void reset(){
        ofertasRecibidas.clear();
        subastadores.clear();
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    public Set<IObservador> getSubastadores() {
        return subastadores;
    }

    
}
