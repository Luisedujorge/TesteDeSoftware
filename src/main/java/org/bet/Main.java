package org.bet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.println("Sistema de apostas");
        int option = 1;
        SistemaDeApostas sistema = new SistemaDeApostas();
        Scanner scanner = new Scanner(System.in);

        while(option != 0){
            System.out.println("Escolha uma opção: \n");
            System.out.println("1 - Registar Apostador");
            System.out.println("2 - Registar Partida");
            System.out.println("3 - Registar Aposta");
            System.out.println("4 - Ver apostas de cada apostador");
            System.out.println("5 - Ver apostas de cada partida");
            System.out.println("0 - Sair");

            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("Digite o nome, a data de nascimento e o saldo inicial do Apostador");
                String nome = scanner.nextLine();
                String data = scanner.nextLine();
                int saldo = scanner.nextInt();
                scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(data, formatter);
                Apostador apostador = new Apostador(nome, date, saldo);
                sistema.registrarApostador(apostador);
            }
            else if(option == 2){
                System.out.println("Digite os nomes dos 2 times");
                String timeA = scanner.nextLine();
                Random r = new Random();
                Time timeAObj = new Time(timeA, r.nextInt(100));

                String timeB = scanner.nextLine();
                Time timeBObj = new Time(timeB, r.nextInt(100));

                Partida partida = new Partida(timeAObj, timeBObj);
                sistema.registrarPartida(partida);
            }
            else if(option == 3){
                System.out.println("Insira os dados da aposta");
                String jogo = scanner.nextLine();
                Partida partida = sistema.buscarPartida(jogo);

                String timeApostado = scanner.nextLine();
                Time time = (timeApostado.equals(partida.getTimeA().toString()) ? partida.getTimeA() : partida.getTimeB());

                String apostadorDaVez = scanner.nextLine();
                Apostador apostador = sistema.buscarApostador(apostadorDaVez);

                int valor = scanner.nextInt();
                scanner.skip("\n");

                sistema.registrarAposta(apostador, time, partida, valor);
            } else if(option == 4){
                for(Apostador apostador : sistema.getApostadores()){
                    System.out.println("Apostas de " + apostador.getNome());
                    for(Aposta aposta : apostador.getApostas()){
                        System.out.println(aposta.toString());
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                }
            } else if(option == 5) {
                for (Partida partida : sistema.getPartidas()) {
                    System.out.println("Apostas da partida " + partida);
                    for(Aposta aposta : partida.getApostas()){
                        System.out.println(aposta.toString());
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                }
            }
            else if(option < 0 || option > 3){
                System.out.println("Digite uma opção válida");
            }
        }

        scanner.close();

    }
}