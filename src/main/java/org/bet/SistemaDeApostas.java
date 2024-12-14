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

    public void adicionarEvento(Partida partida){
        partidas.add(partida);
    }

    public Partida buscarPartida(String nome) {
        for(Partida partida: partidas){
            if(partida.getIdentificador().equalsIgnoreCase(nome)){
                return partida;
            }
        }
        return null;
    }

    public double calcularPremio(int probabilidade, double valor){
        return (101 - (double)probabilidade) * valor / 100 ;
    }

    public void registrarPartida(Partida partida){
        partidas.add(partida);
    }

    public void registrarAposta(Apostador apostador, String time, Partida partida, double valor){
        //Verificar se o apostador tem saldo suficiente
        if(!apostador.saldoSuficiente(valor)) {
            System.out.println("O apostador não possui saldo suficiente para realizar a aposta!");
            return;
        }

        Partida jogo = buscarPartida(partida.getIdentificador());
        Random r = new Random();
        int probabilidade = r.nextInt(101);
        double premio = calcularPremio(probabilidade, valor);
        Aposta aposta = new Aposta(time, jogo, apostador, probabilidade, valor, premio);

        if(apostador.adicionarAposta(aposta)) {
            apostador.removerSaldo(valor);
            jogo.adicionarAposta(aposta);
            System.out.println("Aposta criada!");
        } else{
            System.out.println("Não foi possivel registrar a aposta! Limite de apostas atingido!");
        }
    }

    public void gerarRelatorioPorApostador(){
        System.out.println("Relatório de apostas por apostador" + "\n\n");
        for(Apostador apostador: apostadores){
            List<Aposta> apostas = apostador.getApostas();
            System.out.println("Apostador : " + apostador + "\n");
            for(Aposta aposta: apostas){
                System.out.println(aposta);
            }
        }
    }

    public void gerarRelatorioPorPartida(){
        System.out.println("Relatório de apostas por partida" + "\n\n");
        for(Partida partida: partidas){
            List<Aposta> p = partida.getApostas();
            for(Aposta aposta: p){
                System.out.println(aposta);
            }
        }
    }

    public int getQuantidadeApostadores(){
        return apostadores.size();
    }

    public int getQuantidadeEventos(){
        return partidas.size();
    }

    public void processarResultado(Partida partida, String timeVencedor){
        for(Aposta aposta : partida.getApostas()) {
            if(aposta.getTime() == timeVencedor) {
                aposta.getApostador().adicionarSaldo(aposta.getPremio());
                System.out.println("R$" + aposta.getPremio() + " foram transferidos para o/a " + aposta.getApostador() + "!");
            }
        }
    }

    public void cancelarAposta(Apostador apostador, Aposta aposta){
        if(apostador.getApostas().contains(aposta)) {
            apostador.removerAposta(aposta);
            aposta.getPartida().getApostas().remove(aposta);

            apostador.adicionarSaldo(aposta.getValor());
        }
    }
}

//.