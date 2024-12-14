import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ApostadorTest {
    private Apostador apostador;
    private Aposta aposta;
    private Partida evento;

    @Before
    public void setUp(){
        evento = new Partida("Sao Paulo", "Bahia", "futebol", "22/11");
        aposta = new Aposta("Sao Paulo", evento, apostador, 70, 300, 500);
        apostador = new Apostador("Luis", 1000);
    }

    @Test
    public void testNovaAposta(){
        boolean test = apostador.adicionarAposta(aposta);
        assertTrue(test);
    }

    @Test
    public void testLimiteDeApostas(){
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        apostador.adicionarAposta(aposta);
        boolean test = apostador.adicionarAposta(aposta);
        assertFalse(test);
    }

    @Test
    public void testAdicionarSaldo(){
        apostador.adicionarSaldo(100);
        assertEquals(1100, apostador.getSaldo(), 0.001);
    }

    @Test
    public void testSaldoSuficiente(){
        assertTrue(apostador.saldoSuficiente(1000));
    }

    @Test
    public void testSaldoInsuficiente(){
        assertFalse(apostador.saldoSuficiente(1001));
    }
}
