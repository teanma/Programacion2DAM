package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.NotANumberException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    private static final double DELTA = 0.001;

    @Test
    public void additionTest() {
        List<Integer> numeros = new ArrayList<>();

        numeros.add(3);
        numeros.add(5);

        int res = Calculator.addition(numeros);

        Assert.assertEquals(8, res);
    }

    //solución del profesor
    @Test
    public void sumaTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5);

        int res = Calculator.addition(numbers);

        Assert.assertEquals(12, res);
    }

    //lista vacía
    @Test
    public void emptyListAddition() {
        List<Integer> numbers = Arrays.asList();

        int res = Calculator.addition(numbers);

        Assert.assertEquals(0, res);
    }

    @Test
    public void averageTest() throws NotANumberException {
        List<Double> numeros = new ArrayList<>();

        numeros.add(2.5);
        numeros.add(8.3);

        double avg = Calculator.average(numeros);

        Assert.assertEquals(5.4, avg, DELTA);
    }

    @Test
    public void mediaTest() throws NotANumberException {
        List<Double> numeros = Arrays.asList(2.5, 8.3);

        double avg = Calculator.average(numeros);

        Assert.assertEquals(5.4, avg, DELTA);
    }

    @Test(expected = NotANumberException.class)
    public void emptyListAverageTest() throws NotANumberException {
        List<Double> numeros = Arrays.asList();

        double avg = Calculator.average(numeros);
    }
}
