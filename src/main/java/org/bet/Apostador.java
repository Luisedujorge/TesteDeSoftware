package org.bet;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

public class Apostador{
    protected String nome;
    private LocalDate dataNascimento;
    private double saldo;
    private List<Aposta> apostas;

    public Apostador(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.saldo = 0;
        this.apostas = new ArrayList<>();
    }

    public Apostador(String nome, LocalDate dataNascimento, double saldo){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.apostas = new ArrayList<>();
    }

    public void adicionarAposta(Aposta aposta) throws IllegalStateException  {
        if(this.apostas.contains(aposta)){
           throw new IllegalStateException("Aposta já cadastrada");
        }
        apostas.add(aposta);
    }

    public void removerAposta(Aposta aposta) throws IllegalStateException {
        if(!this.apostas.contains(aposta)){
            throw new IllegalStateException("Aposta inexistente");
        }
        this.apostas.remove(aposta);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Aposta> getApostas(){
        return this.apostas;
    }

    public String toString(){
        return this.nome;
    }

    public void depositar(double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0!");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws IllegalArgumentException {
        if(valor <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0!");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Valor deve ser maior do que o saldo da conta!");
        }
        this.saldo -= valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public boolean saldoSuficiente(double valorAposta){
        return this.saldo >= valorAposta;
    }

    public boolean MaiorIdade() {
        return this.getIdade() >= 18;
    }

    public void mudarDataNascimento(LocalDate novaDataNascimento) {
        this.dataNascimento = novaDataNascimento;
    }

}
