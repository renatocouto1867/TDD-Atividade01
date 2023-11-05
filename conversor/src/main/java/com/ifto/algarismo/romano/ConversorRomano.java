package com.ifto.algarismo.romano;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorRomano {

    private int converteParaArabico(String valor) {
        Map<Character, Integer> romanoParaArabico = new HashMap<>();
        romanoParaArabico.put('I', 1);
        romanoParaArabico.put('V', 5);
        romanoParaArabico.put('X', 10);
        romanoParaArabico.put('L', 50);
        romanoParaArabico.put('C', 100);
        romanoParaArabico.put('D', 500);
        romanoParaArabico.put('M', 1000);

        int result = 0;
        int previousValue = 0;
        String numeroRomano = valor.toUpperCase();

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            int value = romanoParaArabico.get(numeroRomano.charAt(i));

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
    private boolean isNull(String valorDigitado) {
        return valorDigitado != null && !valorDigitado.isEmpty();
    }// verificaNull

    //verifica se é numérico
    private boolean isNumeric(String valor) {
        for (char caractere : valor.toCharArray()) {
            if (!Character.isDigit(caractere)) {
                return false;
            }
        }
        return true;
    }

    //Verifica se é zero
    private boolean isZero(String valor) {
        return valor.equals("0");
    }

    //verifica se é menor que 4000
    private boolean isSmaller4000(String valor) {
        return Integer.parseInt(valor) < 4000;
    }

    // chama validação
    public String converte(String valor) {
        if (isNull(valor)) {
            if (isNumeric(valor)) {
                if (isSmaller4000(valor)) {
                    if (!isZero(valor)) {
                        return "Valor em Romano: " + converteParaRomano(valor);
                    } else {
                        return "Não exite representação para ZERO em algarimos Romanos";
                    }
                } else {
                    return "O valor máximo para conversão é 3999";
                }
            } else {
                if (isRomano(valor)) {
                    return "Valor em Arabico: " + converteParaArabico(valor);
                } else {
                    return "Valor não é um algarismo Romano válido";
                }
            }
        } else {
            return "Valor não informado";
        }

    }//converte


    //Verifica que é um algarismo romano
    private boolean isRomano(String valorDigitado) {
        String valor = valorDigitado.toUpperCase();
        Pattern pattern = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        Matcher matcher = pattern.matcher(valor);
        return matcher.matches();
    }

    private String converteParaRomano(String numeroArabico) {
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

        int numero = Integer.parseInt(numeroArabico);

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
