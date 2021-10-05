package org.iesfm.racecondition.lista;

import org.iesfm.racecondition.increment.Accumulator;
import org.iesfm.racecondition.increment.IncrementTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static Logger log = LoggerFactory.getLogger(org.iesfm.racecondition.increment.Main.class);

    public static void main(String[] args) {
        List<Integer> lista = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new AddToListTask(lista, 100000));
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Hay " + lista.size() + " elementos en la lista");
    }
}
