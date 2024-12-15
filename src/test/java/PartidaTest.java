import org.bet.Aposta;
import org.bet.Partida;
import org.bet.Time;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PartidaTest {
    private Partida partida;
    private Time timeA;
    private Time timeB;
    private Aposta aposta;

    @Before
    public void setUp(){
        timeA = mock(Time.class);
        timeB = mock(Time.class);
        aposta = mock(Aposta.class);
        partida = new Partida(timeA, timeB, "futebol", "22/11");
    }

    @Test
    public void testNenhumaAposta(){
        int qtdApostas = partida.getApostas().size();
        int expected = 0;
        assertEquals(expected, qtdApostas);
    }


    @Test
    public void testAdicionarAposta(){
        partida.adicionarAposta(aposta);
        int tamanho = partida.getApostas().size();
        int expected = 1;
        assertEquals(expected, tamanho);
    }
}