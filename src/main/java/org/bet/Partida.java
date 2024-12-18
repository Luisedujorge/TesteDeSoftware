package org.bet;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private Time timeA;
    private Time timeB;
    private String esporte;
    private String data;
    private List<Aposta> apostas;

    public Partida(Time timeA, Time timeB, String esporte, String data){
        this.timeA = timeA;
        this.timeB = timeB;
        this.esporte = esporte;
        this.data = data;
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
}