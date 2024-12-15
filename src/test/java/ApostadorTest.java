import org.bet.Aposta;
import org.bet.Apostador;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class ApostadorTest {
    private Apostador apostador;
    private Aposta apostaMock;

    @Before
    public void setUp(){
        apostaMock = mock(Aposta.class);
        apostador = new Apostador("Luis", 1000);
    }

    @Test
    public void testNovaAposta(){
        apostador.adicionarAposta(apostaMock);
        int qtdApostas = apostador.getApostas().size();
        int expected = 1;
        assertEquals(qtdApostas, expected);
    }

    @Test
    public void testDepositarPositivo(){
        apostador.depositar(100);
        int expected = 1100;
        assertEquals(expected, apostador.getSaldo(), 0.001);
        apostador.sacar(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositarNegativo(){
        apostador.depositar(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositarZero(){
        apostador.depositar(0);
    }

    @Test
    public void testSacarPositivo(){
        apostador.sacar(100);
        int expected = 900;
        assertEquals(expected, apostador.getSaldo(), 0.001);
        apostador.depositar(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSacarNegativo(){
        apostador.sacar(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSacarZero(){
        apostador.sacar(0);
    }

    @Test
    public void testSaldoSuficiente(){
        boolean resultado = apostador.saldoSuficiente(1000);
        assertTrue(resultado);
    }

    @Test
    public void testSaldoInsuficiente(){
        boolean resultado = apostador.saldoSuficiente(1001);
        assertFalse(resultado);
    }
}
