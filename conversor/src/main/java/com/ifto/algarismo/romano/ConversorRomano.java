package com.ifto.algarismo.romano;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorRomano {

    public int converteParaArabico(String valor) {
        if (!verificaRomano(valor)){
            return -1;//significa que o valor é invalido.
        }

        Map<Character, Integer> romanoṔaraArabico = new HashMap<>();
        romanoṔaraArabico.put('I', 1);
        romanoṔaraArabico.put('V', 5);
        romanoṔaraArabico.put('X', 10);
        romanoṔaraArabico.put('L', 50);
        romanoṔaraArabico.put('C', 100);
        romanoṔaraArabico.put('D', 500);
        romanoṔaraArabico.put('M', 1000);

        int result = 0;
        int previousValue = 0;
        String numeroRomano = valor.toUpperCase();

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            int value = romanoṔaraArabico.get(numeroRomano.charAt(i));

            if (value < previousValue) {
                result -= value;
            } else {
                result += value;
            }
            previousValue = value;
        }

        return result;
    }// converteParaArabico

    // Verifica se foi informado um número romano vazio ou nulo
    public boolean verificaNull(String valorDigitado) {

        return valorDigitado != null && !valorDigitado.isEmpty();
    }// verificaNull

    // chama validação
    public int tipoDado(String valor) {

        if (verificaNumero(valor)) {
            return 1;
        }
        if (verificaRomano(valor)) {
            return 2;
        } else {
            return 0;
        }

    }//chama validação

    // validade se um numero foi recebido
    public boolean verificaNumero(String valor) {

        if (valor == null || valor.isEmpty()) {
            return false;
        }

        for (char caractere : valor.toCharArray()) {
            if (!Character.isDigit(caractere)) {
                return false;
            }
        }

        return true;

    }

    private boolean verificaRomano(String valorDigitado) {
        String valor = valorDigitado.toUpperCase();
        if (verificaNull(valorDigitado)) {
            Pattern pattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
            Matcher matcher = pattern.matcher(valor);
            boolean regexValido = matcher.matches();

            return regexValido;

        } else {
            return false;
        }

    }

    public String converteParaRomano(String numeroArabico) {
        if(numeroArabico.equals("0")){
            return "Não exite representação paro o Zero em Algarismo romano";
        }
        Map<Integer, String> mapaArabicoRomano = new LinkedHashMap<>();

        mapaArabicoRomano.put(1000, "M");
        mapaArabicoRomano.put(900, "CM");
        mapaArabicoRomano.put(500, "D");
        mapaArabicoRomano.put(400, "CD");
        mapaArabicoRomano.put(100, "C");
        mapaArabicoRomano.put(90, "XC");
        mapaArabicoRomano.put(50, "L");
        mapaArabicoRomano.put(40, "XL");
        mapaArabicoRomano.put(10, "X");
        mapaArabicoRomano.put(9, "IX");
        mapaArabicoRomano.put(5, "V");
        mapaArabicoRomano.put(4, "IV");
        mapaArabicoRomano.put(1, "I");


        if (!verificaNumero(numeroArabico)) {
            throw new IllegalArgumentException("O dado digitado não contem só numeros");
        }

        int numero = Integer.parseInt(numeroArabico);

        if (numero <= 0 || numero > 3999) {
            return ("Número fora do intervalo válido (1-3999).");
        }

        StringBuilder resultado = new StringBuilder();

        for (Map.Entry<Integer, String> entry : mapaArabicoRomano.entrySet()) {
            int valorArabico = entry.getKey();
            String valorRomano = entry.getValue();

            while (numero >= valorArabico) {
                resultado.append(valorRomano);
                numero -= valorArabico;
            }
        }

        return resultado.toString();

    } // ConverteParaRomano


}
