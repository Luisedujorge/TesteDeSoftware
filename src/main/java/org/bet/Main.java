/**
 * @author Luís Eduardo Jorge Almeida
 * Exemplo de uso estático, apenas para verificar as funcionalidades
 *
 */
package org.bet;

public class Main{
    public static void main(String[] args){
        SistemaDeApostas sistema = new SistemaDeApostas();

        Apostador luis = new Apostador("Luis", 100);
        Apostador eduardo = new Apostador("Eduardo", 200);
        sistema.registrarApostador(luis);
        sistema.registrarApostador(eduardo);

        Partida partida1 = new Partida("Sao Paulo", "Cruzeiro", "futebol", "21/11/24");
        Partida partida2 = new Partida("Fortaleza", "Bahia", "futebol", "22/11/24");
        sistema.registrarPartida(partida1);
        sistema.registrarPartida(partida2);

        sistema.registrarAposta(luis, "Sao Paulo", partida1, 50);
        sistema.registrarAposta(eduardo, "Bahia", partida2, 70);
        sistema.registrarAposta(luis, "Bahia", partida2, 20);
        sistema.registrarAposta(eduardo, "Cruzeiro", partida1, 70);

        sistema.gerarRelatorioPorApostador();
        sistema.gerarRelatorioPorPartida();
    }
}