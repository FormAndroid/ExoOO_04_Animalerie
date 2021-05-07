package be.bxl.formation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //TODO Correction de l'animalerie

        ArrayList<Double> values = new ArrayList<>();
        values.add(3.14);
        values.add(42.0);
        values.add(5.5);
        values.add(10.0);

        for(double d : values) {

            if(d == 42) {
                values.remove(d);
            }
        }
    }
}
