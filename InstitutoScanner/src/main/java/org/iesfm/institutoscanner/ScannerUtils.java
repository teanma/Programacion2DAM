package org.iesfm.institutoscanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {

    private static final Logger log = LoggerFactory.getLogger(ScannerUtils.class);

    private Scanner scanner;

    public ScannerUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readNumber() {
        Integer n = null;
        while (n == null) {
            try {
                log.info("Introduce un número");
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("Error, no es un número");
            } finally {
                scanner.nextLine();
            }
        }
        return n;
    }

    public int readPositiveNumber() {
        int n = readNumber();
        while (n <= 0) {
            log.error("Error, ntroduce un número mayor que 0");
            n = readNumber();
        }
        return n;
    }
}
