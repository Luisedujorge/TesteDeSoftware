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

    public void adicionarAposta(Aposta aposta) throws IllegalStateException  {
        if(this.apostas.contains(aposta)){
           throw new IllegalStateException("Aposta já cadastrada");
        }
        apostas.add(aposta);
        this.removerSaldo(aposta.getValor());
    }

    public void removerAposta(Aposta aposta) throws IllegalStateException {
        if(!this.apostas.contains(aposta)){
            throw new IllegalStateException("Aposta inexistente");
        }
        this.apostas.remove(aposta);
    }

    public List<Aposta> getApostas(){
        return this.apostas;
    }

    public String toString(){
        return this.nome;
    }

    public void adicionarSaldo(double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0!");
        }
        this.saldo += valor;
    }

    public void removerSaldo(double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0!");
        }
        this.saldo -= valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean saldoSuficiente(double valorAposta){
        return this.saldo >= valorAposta;
    }
}
