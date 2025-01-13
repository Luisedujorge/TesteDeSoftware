import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SistemaDeApostasTest {
    private SistemaDeApostas sistema;

    @Before
    public void setUp(){
        sistema = new SistemaDeApostas();
    }

    @Test
    public void testNenhumApostador(){
        int test = sistema.getQuantidadeApostadores();
        int expected = 0;
        assertEquals(expected, test);
    }

    @Test
    public void testNenhumEvento(){
        int test = sistema.getQuantidadeEventos();
        int expected = 0;
        assertEquals(expected, test);
    }


    @Test
    public void testCalularPremio(){
        double valorPremio = sistema.calcularPremio(1.5, 100);
        assertEquals(150, valorPremio, 0.001);
    }
}