package com.ifto.algarismo.romano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorRomanoTest {
    ConversorRomano conversorRomano;

    @BeforeEach
    void setUP() {
        conversorRomano = new ConversorRomano();
    }

    //Criar testes específicos para demonstrar que as regras referentes a soma e a
    //subtração apresentadas anteriormente foram respeitadas;
    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "Valor em Romano: XXX,30",
            "Valor em Romano: XX,20",
            "Valor em Romano: CC,200",
            "Valor em Romano: CCC,300"
    })
    void deveSomar(String part1, String part2) {
        assertEquals(part1, conversorRomano.converte(part2));
    }

    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "Valor em Romano: IX,9",
            "Valor em Romano: XL,40",
            "Valor em Romano: XC,90",
            "Valor em Romano: CM,900"
    })
    void deveSubitrair(String part1, String part2) {
        assertEquals(part1, conversorRomano.converte(part2));
    }

    //Criar testes para verificar que não é permitida a repetição de caracteres
    // maiores que três;

    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "Valor não é um algarismo Romano válido,XXXX",
            "Valor não é um algarismo Romano válido,CCCC",
            "Valor não é um algarismo Romano válido,IIII"
    })
    void validaRepeticao(String part1, String part2) {
        assertEquals(part1, conversorRomano.converte(part2));
    }

    // Criar teste que verifiquem as regras referentes ao uso dos símbolos I, X, L e C,
    // está em conformidade com o que foi apresentado anteriormente
    @ParameterizedTest(name = "{1}{2}")
    @CsvSource({
            "Valor em Arabico: 4,IV",
            "Valor não é um algarismo Romano válido,IIV",
            "Valor não é um algarismo Romano válido,IL",
            "Valor não é um algarismo Romano válido,LC",
            "Valor em Arabico: 400,CD",
            "Valor em Arabico: 900,CM",
            "Valor não é um algarismo Romano válido,CCM"
    })
    void validaAntecessor(String part1, String part2) {
        assertEquals(part1, conversorRomano.converte(part2));
    }

    // Criar um teste para verificar se uma mensagem é informada quando o valor
    // decimal a ser convertido em romano for igual a zero.

    @Test
    void testaZero() {
        assertEquals("Não exite representação para ZERO em algarimos Romanos", conversorRomano.converte("0"));
    }

    // Criar um teste para verificar se um valor decimal informado é maior que o maior
    // valor correspondente em algarismos romanos.
    @Test
    void valorMaximo() {
        assertEquals("O valor máximo para conversão é 3999", conversorRomano.converte("4000"));
    }
}
