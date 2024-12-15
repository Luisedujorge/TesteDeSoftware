package org.bet;

import java.util.ArrayList;
import java.util.List;

public class Apostador{
    private static int counter = 0;
    private int id;
    protected String nome;
    private double saldo;
    private List<Aposta> apostas;


    public Apostador(String nome){
        this.id = ++counter;
        this.nome = nome;
        this.saldo = 0;
        this.apostas = new ArrayList<>();
    }

    public Apostador(String nome, double saldo){
        this.id = ++counter;
        this.nome = nome;
        this.saldo = saldo;
        this.apostas = new ArrayList<>();
    }

    public void adicionarAposta(Aposta aposta) throws IllegalStateException  {
        if(this.apostas.contains(aposta)){
           throw new IllegalStateException("Aposta já cadastrada");
        }
        this.apostas.add(aposta);
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

    public void depositar(double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor a depositar deve ser maior que 0.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor a sacar deve ser maior que 0.");
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
