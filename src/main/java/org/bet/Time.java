package org.bet;

public class Time {
    private String nome;
    private int qualidade;

    public Time(String nome, int qualidade){
        this.nome = nome;
        this.qualidade = qualidade;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void aumentarQualidade(int valor){
        this.qualidade += valor;
        if(this.qualidade > 100){
            this.qualidade = 100;
        }
    }

    public void reduzirQualidade(int valor){
        this.qualidade -= valor;
        if(this.qualidade < 1){
            this.qualidade = 1;
        }
    }

    public int getQualidade(){
        return this.qualidade;
    }

}
