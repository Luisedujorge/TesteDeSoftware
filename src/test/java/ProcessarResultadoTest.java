import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.bet.Time;
import org.bet.Aposta;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class ProcessarResultadoTest {
    private SistemaDeApostas sistema;
    private Apostador apostador1;
    private Apostador apostador2;
    private Time timeA;
    private Time timeB;
    private Partida partida;

    @Before
    public void setUp() {
        sistema = new SistemaDeApostas();
        apostador1 = new Apostador("Luis", LocalDate.of(2002, 1, 21),1000);
        apostador2 = new Apostador("Igor", LocalDate.of(2001, 1, 1), 1000);

        timeA = new Time("São Paulo", 5);
        timeB = new Time("Cruzeiro", 5);

        partida = new Partida(timeA, timeB);

        sistema.registrarApostador(apostador1);
        sistema.registrarApostador(apostador2);
        sistema.registrarPartida(partida);

        sistema.registrarAposta(apostador1, timeA, partida, 100.0);
        sistema.registrarAposta(apostador2, timeB, partida, 100.0);

    }

    @Test
    public void testProcessarResultadoTimeAVence() {
        double saldoInicial1 = apostador1.getSaldo();
        double saldoInicial2 = apostador2.getSaldo();
        Aposta aposta = apostador1.getApostas().getFirst();

        sistema.processarResultado(partida, "São Paulo");

        assertEquals(saldoInicial1 + aposta.getPremio(), apostador1.getSaldo(), 0.001);
        assertEquals(saldoInicial2, apostador2.getSaldo(), 0.001);
    }

    @Test
    public void testProcessarResultadoTimeBVence() {
        double saldoInicial1 = apostador1.getSaldo();
        double saldoInicial2 = apostador2.getSaldo();
        Aposta aposta = apostador2.getApostas().getFirst();

        sistema.processarResultado(partida, "Cruzeiro");

        assertEquals(saldoInicial2 + aposta.getPremio(), apostador2.getSaldo(), 0.001);
        assertEquals(saldoInicial1, apostador1.getSaldo(), 0.001);
    }

    @Test
    public void testProcessarResultadoMultiplasApostasVencedoras() {
        Apostador apostador3 = new Apostador("Carlos", LocalDate.of(2000, 1, 1), 1000);
        sistema.registrarApostador(apostador3);
        sistema.registrarAposta(apostador3, timeA, partida, 100);
        Aposta aposta1 = apostador1.getApostas().getFirst();
        Aposta aposta3 = apostador3.getApostas().getFirst();

        double saldoInicial1 = apostador1.getSaldo();
        double saldoInicial2 = apostador2.getSaldo();
        double saldoInicial3 = apostador3.getSaldo();

        sistema.processarResultado(partida, "São Paulo");

        assertEquals(saldoInicial1 + aposta1.getPremio(), apostador1.getSaldo(), 0.001);
        assertEquals(saldoInicial3 + aposta3.getPremio(), apostador3.getSaldo(), 0.001);
        assertEquals(saldoInicial2, apostador2.getSaldo(), 0.001);
    }
}


