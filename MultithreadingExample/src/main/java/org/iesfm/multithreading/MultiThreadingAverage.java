package org.iesfm.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiThreadingAverage {

    public static void main(String[] args) {

        Runnable sumas = new Runnable() {
            @Override
            public void run() {
                List<Double> numbers = Arrays.asList(3.5, 4.5, 4.0);
                double sum = addition(numbers);
                System.out.println("La suma es: " + sum);
            }
        };
        Thread sumasThread = new Thread(sumas);
        sumasThread.start();

        Runnable medias = new Runnable() {
            @Override
            public void run() {
                List<Double> numbers = Arrays.asList(3.5, 4.5, 4.0);
                double avg = average(numbers);
                System.out.println("La media es: " + avg);
            }
        };
        Thread mediasThread = new Thread(medias);
        mediasThread.start();
    }

    public static double addition(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum = num + sum;
        }
        return sum;
    }

    public static double average(List<Double> numbers) {
        double avg = 0;
        for (double num : numbers) {
            avg = num + avg;
        }
        return avg / numbers.size();
    }
}
