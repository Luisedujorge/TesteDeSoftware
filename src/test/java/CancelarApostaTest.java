import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.bet.Partida;
import org.bet.Time;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
public class CancelarApostaTest {
    private SistemaDeApostas sistema;
    private Apostador apostador;
    private Time timeA;
    private Time timeB;
    private Partida partida;
    private Aposta aposta;

    @Before
    public void setUp() {
        sistema = new SistemaDeApostas();
        apostador = new Apostador("Luis", LocalDate.of(2002, 01, 21),1000);
        timeA = new Time("São Paulo", 5);
        timeB = new Time("Cruzeiro", 5);
        partida = new Partida(timeA, timeB, "Futebol", "2024-01-12");
        sistema.registrarApostador(apostador);
        sistema.registrarPartida(partida);

        sistema.registrarAposta(apostador, timeA, partida, 100);
        aposta = apostador.getApostas().get(0);
    }

    @Test
    public void testCancelarApostaComSucesso() {
        double saldoInicial = apostador.getSaldo();
        int quantidadeApostasInicial = apostador.getApostas().size();

        sistema.cancelarAposta(apostador, aposta);

        assertEquals(quantidadeApostasInicial - 1, apostador.getApostas().size());
        assertFalse(partida.getApostas().contains(aposta));
        assertEquals(saldoInicial + aposta.getValor(), apostador.getSaldo(), 0.001);
    }


    @Test
    public void testCancelarApostaDeApostadorDiferente() {
        Apostador outroApostador = new Apostador("Igor", LocalDate.of(2001, 1, 1), 1000);
        sistema.registrarApostador(outroApostador);

        double saldoInicial = apostador.getSaldo();
        double saldoInicialOutro = outroApostador.getSaldo();

        sistema.cancelarAposta(outroApostador, aposta);

        assertEquals(saldoInicial, apostador.getSaldo(), 0.001);
        assertEquals(saldoInicialOutro, outroApostador.getSaldo(), 0.001);
        assertTrue(apostador.getApostas().contains(aposta));
    }


}
