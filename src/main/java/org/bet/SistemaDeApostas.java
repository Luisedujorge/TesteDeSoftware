package org.bet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaDeApostas{
    private List<Apostador> apostadores;
    private List<Partida> partidas;

    public SistemaDeApostas(){
        this.apostadores = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public void registrarApostador(Apostador apostador){
        apostadores.add(apostador);
    }

    public Partida buscarPartida(String nome) {
        return partidas.stream()
                .filter(partida -> partida.getIdentificador().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }


    public double calcularPremio(int probabilidade, double valor){
        return (101 - (double)probabilidade) * valor / 100 ;
    }

    public void registrarPartida(Partida partida){
        partidas.add(partida);
    }

    public void registrarAposta(Apostador apostador, Time time, Partida partida, double valor){
        if(!apostador.saldoSuficiente(valor)) {
            System.out.println("Saldo insuficiente para realizar a aposta!");
            return;
        }

        Partida jogo = buscarPartida(partida.getIdentificador());
        Random r = new Random();
        int probabilidade = r.nextInt(101);
        double premio = calcularPremio(probabilidade, valor);
        Aposta aposta = new Aposta(time, jogo, apostador, probabilidade, valor, premio);
        apostador.adicionarAposta(aposta);
        jogo.adicionarAposta(aposta);

    }

    public int getQuantidadeApostadores(){
        return apostadores.size();
    }

    public int getQuantidadeEventos(){
        return partidas.size();
    }
}