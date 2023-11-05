package com.ifto.algarismo.romano;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("O Sistema converte numeros Arabicos em Romanos\n" +
                "o sistema tambem converte Romanos em Arabicos\nDigite um Valor: ");
        String numero = (new Scanner(System.in)).nextLine();

        ConversorRomano conversor = new ConversorRomano();

        // System.out.println(String.valueOf(conversor.retornarNumeroArabico(numero)));

        if (conversor.tipoDado(numero) == 1) {

            String valor = conversor.converteParaRomano(numero);

            System.out.println("O numero " + numero + " em algarismo romano é: " + valor);

            String prova = String.valueOf(conversor.converteParaArabico(valor));
            if (prova.equals("-1")){
                System.out.println("valor invalido");
            }else {
                System.out.println("Prova:\nO numero " + valor + " em algarismo romano é: " +
                        prova);
            }

        } else if (conversor.tipoDado(numero) == 2) {
            String valor = String.valueOf(conversor.converteParaArabico(numero));
            System.out.println(valor);

            System.out.println("O algarismo romano " + numero + " em Arabico é: " + valor);


            String prova = conversor.converteParaRomano(valor);
            if (prova.equals("-1")){
                System.out.println("valor invalido");
            }else {
                System.out.println("Prova:\nO numero " + valor + " em algarismo romano é: " +
                        conversor.converteParaRomano(valor));
            }


        } else {
            System.out.println("valor invalido");
        }

    }
}
