import org.bet.Apostador;
import org.bet.SistemaDeApostas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class RegistrarApostadorTest {
    private SistemaDeApostas sistema;
    private Apostador apostador;

    @Before
    public void setUp() {
        sistema = new SistemaDeApostas();
    }

    @Test
    public void testRegistrarApostadorMenorDeIdade() {
        apostador = new Apostador("Luis", LocalDate.of(2010, 1, 1), 1000);
        sistema.registrarApostador(apostador);

        assertEquals(0, sistema.getQuantidadeApostadores());
    }

    @Test
    public void testRegistrarApostadorMaiorDeIdade() {
        apostador = new Apostador("Luis", LocalDate.of(2000, 1, 1), 1000);
        sistema.registrarApostador(apostador);

        assertEquals(1, sistema.getQuantidadeApostadores());
    }

    @Test
    public void testRegistrarVariosApostadores() {
        apostador = new Apostador("Luis", LocalDate.of(2000, 1, 1), 1000);
        Apostador apostador2 = new Apostador("Igor", LocalDate.of(2000, 1, 1), 1000);
        Apostador apostador3 = new Apostador("João", LocalDate.of(2000, 1, 1), 1000);
        Apostador apostador4 = new Apostador("Bruno", LocalDate.of(2010, 1, 1), 1000);

        sistema.registrarApostador(apostador);
        sistema.registrarApostador(apostador2);
        sistema.registrarApostador(apostador3);
        sistema.registrarApostador(apostador4);

        assertEquals(3, sistema.getQuantidadeApostadores());
    }
}