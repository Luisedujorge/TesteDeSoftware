package org.bet;

public class Time {
    private static int counter = 0;
    private int id;
    private String nome;
    private int qualidade;

    public Time(String nome, int qualidade){
        this.id = ++counter;
        this.nome = nome;
        this.qualidade = qualidade;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void aumentarQualidade(int valor){
        this.qualidade += valor;
        if(this.qualidade > 10){
            this.qualidade = 10;
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
//oi
