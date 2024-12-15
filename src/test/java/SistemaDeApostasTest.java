import static org.junit.Assert.*;

import org.bet.Aposta;
import org.bet.Apostador;
import org.bet.Partida;
import org.bet.SistemaDeApostas;
import org.junit.Before;
import org.junit.Test;

public class SistemaDeApostasTest {
    private SistemaDeApostas sistema;
    private Apostador apostador;
    private Partida evento;

    @Before
    public void setUp(){
        sistema = new SistemaDeApostas();
    }

    @Test //unidade
    public void testNenhumApostador(){
        int test = sistema.getQuantidadeApostadores();
        assertEquals(0, test);
    }

    @Test //unidade
    public void testNenhumEvento(){
        int test = sistema.getQuantidadeEventos();
        assertEquals(0, test);
    }

    @Test //unidade
    public void testCalularPremio(){
        double valorPremio = sistema.calcularPremio(50, 100);
        assertEquals(51, valorPremio, 0.001);
    }

    /*@Test //integração
    public void testNovoApostador(){
        apostador = new Apostador("Luis", 1000);
        sistema.registrarApostador(apostador);
        int test = sistema.getQuantidadeApostadores();
        assertEquals(1, test);
    }

    @Test //integração
    public void testNovoEvento(){
        Partida evento = new Partida("Sao Paulo", "Cruzeiro", "futebol", "22/11");
        sistema.registrarPartida(evento);
        int test = sistema.getQuantidadeEventos();
        assertEquals(1, test);
    }*/


    /*@Before
    public void setUp2(){
        sistema = new SistemaDeApostas();
        apostador = new Apostador("Luis", 1000);
        evento = new Partida("Sao Paulo", "Cruzeiro", "futebol", "22/11");
        sistema.registrarApostador(apostador);
        sistema.registrarPartida(evento);
    }

    @Test
    public void testProcessarResultadoApostaGanhadora(){
        sistema.registrarAposta(apostador, "Sao Paulo", evento, 100);
        double saldo = apostador.getSaldo();
        sistema.processarResultado(evento, "Sao Paulo");
        for (Aposta aposta : evento.getApostas()) {
            double prize = aposta.getPremio();
            saldo += prize;
            assertEquals(apostador.getSaldo(), saldo, 0.001);
        }
    }

    @Test
    public void testProcessarResultadoApostaPerdedora(){
        sistema.registrarAposta(apostador, "Cruzeiro", evento, 100);
        double saldoInicial = apostador.getSaldo();
        sistema.processarResultado(evento, "Sao Paulo");
        assertEquals(saldoInicial, apostador.getSaldo(), 0.001);
    }

    @Test
    public void testCancelarAposta(){
        double saldoInicial = apostador.getSaldo();
        sistema.registrarAposta(apostador, "Sao Paulo", evento, 100);
        Aposta aposta = apostador.getApostas().getFirst();
        sistema.cancelarAposta(apostador, aposta);
        assertEquals(saldoInicial, apostador.getSaldo(), 0.001);
        assertEquals(0, apostador.getApostas().size());
        assertEquals(0, evento.getApostas().size());
    }

    @Test
    public void testProcessarResultadoApostasMultiplas(){
        Apostador segundoApostador = new Apostador("Igor", 1000);
        sistema.registrarApostador(segundoApostador);

        sistema.registrarAposta(apostador, "Sao Paulo", evento, 100);
        sistema.registrarAposta(segundoApostador, "Cruzeiro", evento, 100);

        double saldoInicialLuis = apostador.getSaldo();
        double saldoInicialIgor = segundoApostador.getSaldo();

        sistema.processarResultado(evento, "Sao Paulo");

        //Saldo Final Luis
        for (Aposta aposta : evento.getApostas()) {
            if (aposta.getApostador() == apostador) {
                double saldoEsperado = saldoInicialLuis + aposta.getPremio();
                assertEquals(saldoEsperado, apostador.getSaldo(), 0.001);
            }
        }

        //Saldo Final Igor
        for (Aposta aposta : evento.getApostas()) {
            if (aposta.getApostador() == segundoApostador) {
                assertEquals(saldoInicialIgor, segundoApostador.getSaldo(), 0.001);
            }
        }
    }*/
}