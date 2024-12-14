package org.bet;

import java.util.ArrayList;
import java.util.List;

public class Apostador{
    protected String nome;
    private double saldo;
    private List<Aposta> apostas;

    public Apostador(String nome){
        this.nome = nome;
        this.saldo = 0;
        this.apostas = new ArrayList<>();
    }

    public Apostador(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
        this.apostas = new ArrayList<>();
    }

    public boolean adicionarAposta(Aposta aposta){
        if(apostas.size() < 10){
            apostas.add(aposta);
            return true;
        } else{
            System.out.println("Limite de apostas atingido!");
            return false;
        }
    }

    public void removerAposta(Aposta aposta) {
        this.apostas.remove(aposta);
    }

    public List<Aposta> getApostas(){
        return this.apostas;
    }

    public String toString(){
        return this.nome;
    }

    public void adicionarSaldo(double valor) {
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean saldoSuficiente(double valorAposta){
        return this.saldo >= valorAposta;
    }
}
