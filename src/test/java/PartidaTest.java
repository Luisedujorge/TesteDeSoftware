
import static org.junit.Assert.*;

import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;
import org.junit.Before;
import org.junit.Test;

public class PartidaTest {
    private Partida evento;
    private Aposta aposta;

    @Before
    public void setUp(){
        evento = new Partida("Sao Paulo", "Cruzeiro", "futebol", "22/11");
    }

    /*@Test
    public void testNenhumaAposta(){
        int tamanho = evento.getApostas().size();
        assertEquals(0, tamanho);
    }

    @Test
    public void testAdicionarAposta(){
        Apostador apostador = new Apostador("Luis", LocalDate.of(2000, 12, 15), 1000);
        Aposta aposta = new Aposta("Sao Paulo", evento, apostador, 70, 300, 500);
        evento.adicionarAposta(aposta);
        int tamanho = evento.getApostas().size();
        assertEquals(1, tamanho);
    }*///
}