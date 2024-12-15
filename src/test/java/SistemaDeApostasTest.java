import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.junit.Before;
import org.junit.Test;

public class SistemaDeApostasTest {
    private SistemaDeApostas sistema;
    private Apostador apostador;
    private Partida partida;

    @Before
    public void setUp(){
        sistema = new SistemaDeApostas();
        apostador = mock(Apostador.class);
        partida = mock(Partida.class);
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
    public void testNovoApostador(){
        sistema.registrarApostador(apostador);
        int test = sistema.getQuantidadeApostadores();
        int expected = 1;
        assertEquals(expected, test);
    }

    @Test
    public void testNovoEvento(){
        sistema.registrarPartida(partida);
        int test = sistema.getQuantidadeEventos();
        int expected = 1;
        assertEquals(expected, test);
    }


    @Test
    public void testCalularPremio(){
        double valorPremio = sistema.calcularPremio(50, 100);
        assertEquals(51, valorPremio, 0.001);
    }
}