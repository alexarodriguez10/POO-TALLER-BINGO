package main;

import bingo.Bingo;
import bingo.Carton;
/**
 *
 * @author Alexa rodriguez 
 * 
 */
public class Programa {

    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        Carton b1 = bingo.generarCarton();
        System.out.println("Numeros del Carton 1");
        System.out.println(b1.getNum().toString());
        Carton b2 = bingo.generarCarton();
        System.out.println("Numeros del Carton 2");
        System.out.println(b2.getNum().toString());
        Carton b3 = bingo.generarCarton();
        System.out.println("Numeros del Carton 3");
        System.out.println(b3.getNum().toString());

        do {
            int bola = bingo.extraerBola();
            System.out.println("Bola Extraida: " + bola);
        } while (!bingo.finalizado());

        System.out.println("\nFin del Bingo!");
        if (bingo.comprobarCarton(b1)) {
            System.out.println("Carton 1 Gano");
        }

        if (bingo.comprobarCarton(b2)) {
            System.out.println("Carton 2 Gano");
        }

        if (bingo.comprobarCarton(b3)) {
            System.out.println("Carton 3 Gano");
        }
    }
}
