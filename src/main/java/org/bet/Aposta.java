/**
 *
 */
package org.bet;
public class Aposta {

    public static final int ABERTA = 1;
    public static final int FECHADA = 2;

    private String time;
    private Partida partida;
    private Apostador apostador;
    private double valor;
    private double premio;
    private boolean premioTransferido;
    /**
     *
     */
    protected int status = ABERTA;

    /**
     * A probabilidade varia de 0 a 100
     */
    protected int probabilidade = 0;


    /**
     *
     */
    public Aposta(String time, Partida partida, Apostador apostador, int probabilidade, double valor, double premio){
        this.time = time;
        this.partida = partida;
        this.apostador = apostador;
        this.probabilidade = probabilidade;
        this.valor = valor;
        this.premio = premio;
        this.premioTransferido = false;
    }

    /**
     * @param incremento
     */
    public void aumentarProbabilidade(int incremento) {
        this.probabilidade += incremento;
        if(probabilidade > 100){
            probabilidade = 100;
        }
    }

    public void diminuirProbabilidade(int decremento) {
        this.probabilidade -= decremento;
        if(probabilidade < 0){
            probabilidade = 0;
        }
    }

    /**
     * @return
     */
    public int getProbabilidade() {
        return this.probabilidade;
    }

    public String toString(){
        return "Partida: " + partida + "\n"
                + "Time: " + time + "\n"
                + "Probabilidade: " + probabilidade + "\n"
                + "Valor apostado: " + valor + "\n"
                + "Premio: " + premio + "\n";
    }

    public String getTime() {
        return this.time;
    }

    public Apostador getApostador() {
        return this.apostador;
    }

    public double getValor() {
        return this.valor;
    }

    public Partida getPartida() {
        return this.partida;
    }

    public double getPremio() {
        return this.premio;
    }
}
