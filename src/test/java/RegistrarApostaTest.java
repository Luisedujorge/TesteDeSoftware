import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.bet.Time;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class RegistrarApostaTest {
    private SistemaDeApostas sistema;
    private Apostador apostador;
    private Time timeA;
    private Time timeB;
    private Partida partida;

    @Before
    public void setUp() {
        sistema = new SistemaDeApostas();

        timeA = new Time("São Paulo", 5);
        timeB = new Time("Cruzeiro", 5);

        partida = new Partida(timeA, timeB);

        sistema.registrarPartida(partida);
    }

    @Test
    public void testRegistrarApostaComSaldoSuficiente() {
        apostador = new Apostador("Luis", LocalDate.of(2002, 1, 1), 100);
        sistema.registrarApostador(apostador);
        double saldoInicial = apostador.getSaldo();

        sistema.registrarAposta(apostador, timeA, partida, 100);

        assertEquals(1, apostador.getApostas().size());
        assertEquals(saldoInicial - 100, apostador.getSaldo(), 0.001);
        assertEquals(1, partida.getApostas().size());
    }

    @Test
    public void testRegistrarApostaSaldoInsuficiente() {
        apostador = new Apostador("Luis", LocalDate.of(2002, 1, 1), 100);
        sistema.registrarApostador(apostador);
        double saldoInicial = apostador.getSaldo();

        sistema.registrarAposta(apostador, timeA, partida, 101);

        assertEquals(0, apostador.getApostas().size());
        assertEquals(saldoInicial, apostador.getSaldo(), 0.001);
        assertEquals(0, partida.getApostas().size());
    }


}