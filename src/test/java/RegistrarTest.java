import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.bet.Time;
import org.bet.Aposta;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class RegistrarTest {
    private Partida partida;
    private Time timeA;
    private Time timeB;
    private SistemaDeApostas sistema;

    @Before
    public void setUp(){
        //apostador = new Apostador("Luis", LocalDate.of(2002, 1, 21),1000);
        sistema = new SistemaDeApostas();
    }

    @Test
    public void testRegistrarNovaPartidaComTimeAMaisForte(){
        timeA = new Time("Sao Paulo", 80);
        timeB = new Time("Cruzeiro", 40);
        partida = new Partida(timeA, timeB);
        sistema.registrarPartida(partida);

        int qtd = sistema.getQuantidadeEventos();
        int expectedQtd = 1;
        assertEquals(expectedQtd, qtd);

        assertTrue(sistema.getPartidas().contains(partida));

        double[] odds = partida.getOdds();
        double[] expectedOdds = {1.5, 3.0};
        assertArrayEquals(expectedOdds, odds, 0.001);
    }

    @Test
    public void testRegistrarNovaPartidaComTimeBMaisForte(){
        timeA = new Time("Sao Paulo", 40);
        timeB = new Time("Cruzeiro", 80);
        partida = new Partida(timeA, timeB);
        sistema.registrarPartida(partida);

        int qtd = sistema.getQuantidadeEventos();
        int expectedQtd = 1;
        assertEquals(expectedQtd, qtd);

        assertTrue(sistema.getPartidas().contains(partida));

        double[] odds = partida.getOdds();
        double[] expectedOdds = {3.0, 1.5};
        assertArrayEquals(expectedOdds, odds, 0.001);
    }
}
