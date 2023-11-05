package com.ifto.algarismo.romano;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        System.out.print("O Sistema converte numeros Arabicos em Romanos\n" +
                "o sistema tambem converte Romanos em Arabicos\nDigite um Valor: ");
        String numero = (new Scanner(System.in)).nextLine();

        ConversorRomano conversor = new ConversorRomano();

        System.out.println(conversor.converte(numero));


    }
}
