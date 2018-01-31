package com.ivo.chapter3.item20.hierarchy;

/**
 *
 * @author IOAdmin
 */
public class Circle extends Figure {

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    
    
    @Override
    double area() {
        return Math.PI * (radius * radius);
    }

}
