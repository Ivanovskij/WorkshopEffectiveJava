package com.ivo.chapter5.item30;

/**
 *
 * @author IOAdmin
 */
public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = 100;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }
    
}
