package com.ifto.algarismo.romano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorRomanoTest {
    ConversorRomano conversorRomano;
    @BeforeEach
    void setUP(){conversorRomano = new ConversorRomano();}

    //Criar testes específicos para demonstrar que as regras referentes a soma e a
    //subtração apresentadas anteriormente foram respeitadas;
    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "XXX,30",
            "XX,20",
            "CC,200",
            "CCC,300"
    })
    void deveSomar(String part1, String part2){
        assertEquals(part1,conversorRomano.converteParaRomano(part2));
    }

    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "IX,9",
            "XL,40",
            "XC,90",
            "CM,900"
    })
    void deveSubitrair(String part1, String part2){
        assertEquals(part1,conversorRomano.converteParaRomano(part2));
    }

    //Criar testes para verificar que não é permitida a repetição de caracteres
    // maiores que três;

    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "-1,XXXX",
            "-1,CCCC",
            "-1,IIII"
    })
    void validaRepeticao(String part1, String part2){
        assertEquals(part1,Integer.toString(conversorRomano.converteParaArabico(part2)));
    }

    // Criar teste que verifiquem as regras referentes ao uso dos símbolos I, X, L e C,
    // está em conformidade com o que foi apresentado anteriormente
    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "4,IV",
            "-1,IIV",
            "-1,IL",
            "-1,LC",
            "400,CD",
            "900,CM",
            "-1,CCM"
    })
    void validaAntecessor(String part1, String part2){
        assertEquals(part1,Integer.toString(conversorRomano.converteParaArabico(part2)));
    }

    // Criar um teste para verificar se uma mensagem é informada quando o valor
    // decimal a ser convertido em romano for igual a zero.

    @Test
    void testaZero(){
        assertEquals("Não exite representação paro o Zero em Algarismo romano",conversorRomano.converteParaRomano("0"));
    }

    // Criar um teste para verificar se um valor decimal informado é maior que o maior
    // valor correspondente em algarismos romanos.
    @Test
    void valorMaximo(){
        assertEquals("Número fora do intervalo válido (1-3999).",conversorRomano.converteParaRomano("4000"));
    }
}
