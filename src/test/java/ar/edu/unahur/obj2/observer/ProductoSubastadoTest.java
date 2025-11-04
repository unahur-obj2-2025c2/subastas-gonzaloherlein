package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoSubastadoTest {

    private ProductoSubastado producto;
    private Subastador gonzager;
    private Subastador diazdan;
    private Subastador martomau;

    @BeforeEach
    void setUp(){
        Oferta ofertaBase = new Oferta(martomau,0.0);
        producto = new ProductoSubastado();
        gonzager = new Subastador("gonzager", ofertaBase);
        diazdan = new Subastador("diazdan", ofertaBase);
        martomau = new Subastador("martomau", ofertaBase);
        producto.reset();
        gonzager.reiniciarUltimaOferta();
        diazdan.reiniciarUltimaOferta();
        martomau.reiniciarUltimaOferta();

        producto.agregarObservador(gonzager);
        producto.agregarObservador(martomau);

        gonzager.setUltimaOfertaRecibida(ofertaBase);
        martomau.setUltimaOfertaRecibida(ofertaBase);

        producto.recibirOferta(martomau);
        producto.recibirOferta(gonzager);
        producto.recibirOferta(martomau);

    }

    @Test
    void Test1() {
        assertEquals(30.0, martomau.getUltimaOfertaRecibida().getValor());
        assertEquals(30.0, gonzager.getUltimaOfertaRecibida().getValor());
    }

    @Test
    void Test2() {
        assertEquals(martomau,producto.getOfertasRecibidas().getLast().getSubastador());
    }

    @Test
    void Test3() {
        assertEquals(30,martomau.getUltimaOfertaRecibida().getValor());
    }

    @Test
    void Test4() {
        assertEquals(3,producto.getOfertasRecibidas().size());
    }

    @Test
    void Test5() {
        SubastadorNoParticipaEnLaSubastaException exception = Assertions.assertThrows(SubastadorNoParticipaEnLaSubastaException.class, () -> {
                producto.recibirOferta(diazdan);
            });
        assertEquals("El subastador no participa en la subasta", exception.getMessage());
    }
}
