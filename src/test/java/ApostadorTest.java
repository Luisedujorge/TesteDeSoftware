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
        // evento = new Partida("Sao Paulo", "Bahia", "futebol", "22/11");
        // aposta = new Aposta("Sao Paulo", evento, apostador, 70, 300, 500);
        apostador = new Apostador("Luis", 1000);
    }

//    @Test
//    public void testNovaAposta(){
//        boolean test = apostador.adicionarAposta(aposta);
//        assertTrue(test);
//    }

//    @Test
//    public void testLimiteDeApostas(){
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        apostador.adicionarAposta(aposta);
//        boolean test = apostador.adicionarAposta(aposta);
//        assertFalse(test);
//    }


    @Test
    public void testAdicionarSaldoPositivo(){
        apostador.adicionarSaldo(100);
        int expected = 1100;
        assertEquals(expected, apostador.getSaldo(), 0.001);
        apostador.removerSaldo(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarSaldoNegativo(){
        apostador.adicionarSaldo(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarSaldoZero(){
        apostador.adicionarSaldo(0);
    }

    @Test
    public void testRemoverSaldoPositivo(){
        apostador.removerSaldo(100);
        int expected = 900;
        assertEquals(expected, apostador.getSaldo(), 0.001);
        apostador.adicionarSaldo(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverSaldoNegativo(){
        apostador.removerSaldo(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverSaldoZero(){
        apostador.removerSaldo(0);
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
