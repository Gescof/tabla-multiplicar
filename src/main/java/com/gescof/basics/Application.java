package com.gescof.basics;

import lombok.extern.log4j.Log4j2;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * com.gescof.basics.Application.
 *
 * @author Guillermo
 * @version 1.0
 * @since <pre>ago. 20, 2022</pre>
 */
@Log4j2
public class Application {
    private Scanner scanner;
    private static final String CONTINUE_CHAR = "Y";
    private static final String ENDING_CHAR = "N";

    public Application(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public static void main(String[] args) {
        Application application = new Application(System.in);
        application.run();
    }

    /**
     * Runs main method application.
     */
    public void run() {
        log.debug("-----------------------------Aplicación Tabla de Multiplicar-----------------------------");
        process();
        log.debug("-----------------------------Fin del programa-----------------------------");
    }

    /**
     * Process an input as a number from user and returns the multiplication table of the number.
     */
    private void process() {
        boolean result = true;
        while (result) {
            log.debug("Inserte un número del 1 al 9:");
            Short number = getInputNumber();
            if (Objects.isNull(number)) {
                continue;
            }
            log.debug(String.format("Tabla de multiplicar para el número %d", number));
            printTable(number);
            result = isApplicationContinuing();
        }
    }

    /**
     * Gets the input as a number.
     *
     * @return the input introduced as a number or null if input is not in the specified format
     */
    private Short getInputNumber() {
        short number;
        try {
            number = scanner.nextShort();
            if (number < 1 || number > 9) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException ime) {
            log.warn("La entrada escrita no es válida");
            return null;
        }
        return number;
    }

    /**
     * Prints the multiplication table from a number.
     *
     * @param number integer number
     */
    private void printTable(final short number) {
        for (int i = 1; i < 10; i++) {
            log.debug(String.format("%d por %d es igual a %d", number, i, number * i));
        }
    }

    /**
     * Returns whether the user wants to continue or not.
     *
     * @return true if user wants to continue, false otherwise
     */
    private boolean isApplicationContinuing() {
        boolean result = true;
        String response;
        do {
            log.debug("¿Desea continuar con otro número? (Y/N):");
            response = scanner.next();
            if (ENDING_CHAR.equals(response)) {
                result = false;
            } else if (!CONTINUE_CHAR.equals(response)) {
                log.warn("La entrada escrita no es válida");
            }
        } while (!CONTINUE_CHAR.equals(response) && !ENDING_CHAR.equals(response));
        return result;
    }
}
