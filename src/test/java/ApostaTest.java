import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;
import org.bet.Time;
import org.junit.Before;
import org.junit.Test;

public class ApostaTest {
    private Aposta aposta;
    private Partida partida;
    private Apostador apostador;
    private Time time;

    @Before
    public void setUp(){
        partida = mock(Partida.class);
        apostador = mock(Apostador.class);
        time = mock(Time.class);
    }

    @Test
    public void testAumentaProbabilidade(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(10);
        assertEquals(aposta.getProbabilidade(), 70);
    }

    @Test
    public void testDiminuiProbabilidade(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.diminuirProbabilidade(10);
        assertEquals(aposta.getProbabilidade(), 50);
    }

    @Test
    public void testLimiteMaximoProbabilidade(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(50);
        assertEquals(aposta.getProbabilidade(), 100);
    }

    @Test
    public void testLimiteMinixmoProbabilidade(){
        aposta = new Aposta(time, partida, apostador, 30, 300, 500);
        aposta.diminuirProbabilidade(40);
        assertEquals(aposta.getProbabilidade(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiminuiProbabilidadeNegativo(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.diminuirProbabilidade(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAumentaProbabilidadeNegativo(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiminuiProbabilidadeZero(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.diminuirProbabilidade(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAumentaProbabilidadeZero(){
        aposta = new Aposta(time, partida, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(0);
    }

}