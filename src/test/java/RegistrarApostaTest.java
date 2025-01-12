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
        apostador = new Apostador("Luis", LocalDate.of(2002, 1, 1), 100);

        timeA = new Time("São Paulo", 8);
        timeB = new Time("Cruzeiro", 7);

        partida = new Partida(timeA, timeB, "Basquete", "2024-01-12");

        sistema.registrarApostador(apostador);
        sistema.registrarPartida(partida);
    }

    @Test
    public void testRegistrarApostaSaldoInsuficiente() {
        double saldoInicial = apostador.getSaldo();

        sistema.registrarAposta(apostador, timeA, partida, 101);

        assertEquals(0, apostador.getApostas().size());
        assertEquals(saldoInicial, apostador.getSaldo(), 0.001);
        assertEquals(0, partida.getApostas().size());
    }

    @Test
    public void testRegistrarApostaComSaldoSuficiente() {
        double valorAposta = 100;
        double saldoInicial = apostador.getSaldo();

        sistema.registrarAposta(apostador, timeA, partida, valorAposta);

        assertEquals(1, apostador.getApostas().size());
        assertEquals(saldoInicial - valorAposta, apostador.getSaldo(), 0.001);
        assertEquals(1, partida.getApostas().size());
    }
}