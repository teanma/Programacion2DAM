package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.NotANumberException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Hola mundo");
    }

    public static int addition (List<Integer> numeros) {
        int sum = 0;
        //for (int i = 0; i < numeros.size(); i++) {
        //    sum += numeros.get(i);
        //}
        for (int num : numeros) {
            sum = num + sum;
        }
        return sum;
    }

    public static double average (List<Double> numeros) throws NotANumberException {
        if(numeros.isEmpty()) {
            throw new NotANumberException();
        }
        double avg = 0;
        for (double num : numeros) {
            avg = num + avg;
        }
        return avg / numeros.size();
    }
}
