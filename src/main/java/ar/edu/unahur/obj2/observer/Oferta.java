package ar.edu.unahur.obj2.observer;

public class Oferta {
    private final Subastador SUBASTADOR;
    private Double valor = 0.0;
    
    public Oferta(Subastador subastador, Double valor) {
        this.SUBASTADOR = subastador;
        this.valor = valor;
    }

    public Subastador getSubastador() {
        return SUBASTADOR;
    }

    public Double getValor() {
        return valor;
    }

    
}
