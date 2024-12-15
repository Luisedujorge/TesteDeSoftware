import org.bet.Aposta;
import org.bet.Apostador;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ApostadorTest {
    private Apostador apostador;
    private Aposta apostaMock;

    @Before
    public void setUp(){
        apostaMock = mock(Aposta.class);
        apostador = new Apostador("Luis", LocalDate.of(2002, 01, 21),1000);
    }

    @Test
    public void testNovaAposta(){
        apostador.adicionarAposta(apostaMock);
        int qtdApostas = apostador.getApostas().size();
        int expected = 1;
        assertEquals(qtdApostas, expected);
    }

    @Test(expected = IllegalStateException.class)
    public void testAdicionarMesmaAposta2x(){
        apostador.adicionarAposta(apostaMock);
        apostador.adicionarAposta(apostaMock);
    }

    @Test
    public void testRemoverAposta() {
        apostador.adicionarAposta(apostaMock);
        apostador.removerAposta(apostaMock);
        assertEquals(0, apostador.getApostas().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoverApostaInexistente() {
        apostador.removerAposta(apostaMock);
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

    @Test(expected = IllegalArgumentException.class)
    public void testSacarValorMaiorQueSaldo(){
        apostador.sacar(1001);
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

    @Test
    public void testMudarDataNascimento(){
        apostador.mudarDataNascimento(LocalDate.of(2003, 01, 21));
        assertEquals(LocalDate.of(2003, 01, 21), apostador.getDataNascimento());
    }

    @Test
    public void testMaiorIdade(){
        assertTrue(apostador.MaiorIdade());
    }

    @Test
    public void testMenorIdade(){
        Apostador apostador2 = new Apostador("Eduardo", LocalDate.of(2010, 01, 21));
        assertFalse(apostador2.MaiorIdade());
    }
}
