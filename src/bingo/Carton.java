package bingo;

import java.util.ArrayList;
/**
 *
 * @author Alexa rodriguez 
 * 
 */
public class Carton {
    private final ArrayList<Integer> num;
    public Carton(Integer... n) {
        this.num = new ArrayList<>();
        for(Integer i : n) { this.num.add(i); }
    }

    
    public int getTamaño() { return this.num.size(); }
    public ArrayList<Integer> getNum() { return new ArrayList<>(this.num); }
}
