package org.iesfm.racecondition.lista;

import java.util.List;

public class AddToListTask implements Runnable {

    private List<Integer> lista;
    private int n;

    public AddToListTask(List<Integer> lista, int n) {
        this.lista = lista;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            lista.add(i);
        }
    }
}
