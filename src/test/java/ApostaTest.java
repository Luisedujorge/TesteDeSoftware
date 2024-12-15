import static org.junit.Assert.*;

import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ApostaTest {
    private Aposta aposta;
    Partida evento;
    Apostador apostador;

    @Before
    public void setUp(){
        evento = new Partida("Sao Paulo", "Bahia", "futebol", "22/11");
        apostador = new Apostador("Luis", LocalDate.of(2000, 12, 15), 1000);
    }

    @Test
    public void testAumentaProbabilidade(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(10);
        assertEquals(aposta.getProbabilidade(), 70);
    }

    @Test
    public void testDiminuiProbabilidade(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.diminuirProbabilidade(10);
        assertEquals(aposta.getProbabilidade(), 50);
    }

    @Test
    public void testLimiteMaximoProbabilidade(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(50);
        assertEquals(aposta.getProbabilidade(), 100);
    }

    @Test
    public void testLimiteMinixmoProbabilidade(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 30, 300, 500);
        aposta.diminuirProbabilidade(40);
        assertEquals(aposta.getProbabilidade(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiminuiProbabilidadeNegativo(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.diminuirProbabilidade(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAumentaProbabilidadeNegativo(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiminuiProbabilidadeZero(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.diminuirProbabilidade(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAumentaProbabilidadeZero(){
        aposta = new Aposta("Sao Paulo", evento, apostador, 60, 300, 500);
        aposta.aumentarProbabilidade(0);
    }//


}