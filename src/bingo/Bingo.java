package bingo;

import java.util.ArrayList;
/**
 *
 * @author Alexa rodriguez
 * 
 */
public class Bingo {

    private final  ArrayList<Integer> bombo;
    private final  ArrayList<Integer> bolasExtraidas;
    private final  ArrayList<Carton> cartones;
    private final  ArrayList<Carton> cartonesGanadores;

    
    private final static int BolaMayor = 30;
    private final static int TamañoCarton = 9;

    public Bingo() {
        this.bolasExtraidas = new ArrayList<>();
        this.cartones = new ArrayList<>();
        this.bombo = new ArrayList<>();
        this.cartonesGanadores = new ArrayList<>();
        for (int i = 1; i <= BolaMayor; i++) {
            this.bombo.add(i);
        }
    }

    public boolean comprobarCarton(Carton b) {
        return this.bolasExtraidas.containsAll(b.getNum());
    }
    
    
    public boolean finalizado() {
        return (this.bombo.isEmpty() || this.cartonesGanadores.size() > 1);
    }

    
    public Carton generarCarton() {
        ArrayList<Integer> num = new ArrayList<>(this.bombo);
        java.util.Collections.shuffle(num);
        ArrayList<Integer> numerosCarton = new ArrayList<>();
        for (int i = 1; i <= TamañoCarton; i++) {
            int elemento = num.get(0);
            numerosCarton.add(elemento);
            num.remove(0);
        }

        Integer[] n = new Integer[numerosCarton.size()];
        for (int i = 0; i < numerosCarton.size(); i++) {
            n[i] = numerosCarton.get(i);
        }
        Carton b = new Carton(n);
        this.cartones.add(b);
        return b;
    }

    public int extraerBola() {
        if (!finalizado()) {
            java.util.Collections.shuffle(this.bombo);
            int elemento = this.bombo.get(0);
            this.bombo.remove(0);
            this.bolasExtraidas.add(elemento);
            for (Carton b : this.cartones) {
                if (comprobarCarton(b)) {
                    this.cartonesGanadores.add(b);
                    break;
                }
            }
            return elemento;
        } else {
            return 0;
        }
    }
}
