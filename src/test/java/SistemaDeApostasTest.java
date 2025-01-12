import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SistemaDeApostasTest {
    private SistemaDeApostas sistema;
    private Apostador apostadorMock;
    private Partida partidaMock;

    @Before
    public void setUp(){
        sistema = new SistemaDeApostas();
        apostadorMock = mock(Apostador.class);
        partidaMock = mock(Partida.class);
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

//    @Test
//    public void testNovoApostador(){
//        sistema.registrarApostador(apostadorMock);
//        int test = sistema.getQuantidadeApostadores();
//        int expected = 1;
//        assertEquals(expected, test);
//    }
//
//    @Test
//    public void testNovaPartida(){
//        sistema.registrarPartida(partidaMock);
//        int test = sistema.getQuantidadeEventos();
//        int expected = 1;
//        assertEquals(expected, test);
//    }

    @Test
    public void testCalularPremio(){
        double valorPremio = sistema.calcularPremio(50, 100);
        assertEquals(51, valorPremio, 0.001);
    }
}