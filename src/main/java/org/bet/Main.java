package org.bet;

import java.time.LocalDate;

public class Main{
    public static void main(String[] args){
        SistemaDeApostas sistema = new SistemaDeApostas();

        Apostador luis = new Apostador("Luis", LocalDate.of(2000, 12, 15), 1000);
        Apostador eduardo = new Apostador("Eduardo", LocalDate.of(2000, 12, 15), 1000);
        sistema.registrarApostador(luis);
        sistema.registrarApostador(eduardo);

        Time a = new Time("Sao Paulo", 10);
        Time b = new Time("Cruzeiro", 10);
        Time c = new Time("Fortaleza", 10);
        Time d = new Time("Bahia", 10);


        Partida partida1 = new Partida(a, b);
        Partida partida2 = new Partida(c, d);
        sistema.registrarPartida(partida1);
        sistema.registrarPartida(partida2);

    }
}