import org.bet.Partida;
import org.bet.Time;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PartidaTest {
    private Partida partida;
    private Time time;

    @Before
    public void setUp(){
        Time timeA = mock(Time.class);
        Time timeB = mock(Time.class);
        partida = new Partida(timeA, timeB, "futebol", "22/11");
    }

    @Test
    public void testNenhumaAposta(){
        int qtdApostas = partida.getApostas().size();
        int expected = 0;
        assertEquals(expected, qtdApostas);
    }

    /*
    @Test
    public void testAdicionarAposta(){
        Apostador apostador = new Apostador("Luis", LocalDate.of(2000, 12, 15), 1000);
        Aposta aposta = new Aposta("Sao Paulo", evento, apostador, 70, 300, 500);
        evento.adicionarAposta(aposta);
        int tamanho = evento.getApostas().size();
        assertEquals(1, tamanho);
    }*///
}