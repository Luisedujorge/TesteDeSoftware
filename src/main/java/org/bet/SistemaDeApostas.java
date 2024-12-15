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

    public void registrarAposta(Apostador apostador, String time, Partida partida, double valor){
        if(!apostador.saldoSuficiente(valor)) {
            System.out.println("O apostador não possui saldo suficiente para realizar a aposta!");
            return;
        }

        Partida jogo = buscarPartida(partida.getIdentificador());
        Random r = new Random();
        int probabilidade = r.nextInt(101);
        double premio = calcularPremio(probabilidade, valor);
        Aposta aposta = new Aposta(time, jogo, apostador, probabilidade, valor, premio);

        if(apostador.saldoSuficiente(valor)) {
            apostador.adicionarAposta(aposta);
            jogo.adicionarAposta(aposta);
        } else{
            System.out.println("Não foi possivel registrar a aposta! Saldo insuficiente!");
        }
    }

    public int getQuantidadeApostadores(){
        return apostadores.size();
    }

    public int getQuantidadeEventos(){
        return partidas.size();
    }
}