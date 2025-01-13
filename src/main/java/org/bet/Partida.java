package org.bet;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private final Time timeA;
    private final Time timeB;
    private double oddTimeA;
    private double oddTimeB;

    private List<Aposta> apostas;

    public Partida(Time timeA, Time timeB){
        this.timeA = timeA;
        this.timeB = timeB;
        this.apostas = new ArrayList<>();
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public String getIdentificador(){
        return timeA + " X " + timeB;
    }

    public void adicionarAposta(Aposta aposta){
        apostas.add(aposta);
    }

    public String toString(){
        return timeA + " X " + timeB;
    }

    public void calcularOdds(){
        int qualidadeA = timeA.getQualidade();
        int qualidadeB = timeB.getQualidade();
        int qualidadeTotal = qualidadeA + qualidadeB;
        oddTimeA = (double)qualidadeTotal / (double)qualidadeA;
        oddTimeB = (double)qualidadeTotal / (double)qualidadeB;
    }

    public double[] getOdds(){
        return new double[]{oddTimeA, oddTimeB};
    }

    public Time getTimeA(){
        return timeA;
    }

    public Time getTimeB(){
        return timeB;
    }
}