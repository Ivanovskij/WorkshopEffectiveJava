package com.ivo.chapter3.item20.hierarchy;

/**
 *
 * @author IOAdmin
 */
public class Rectangle extends Figure {

    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    double area() {
        return length * width;
    }

}
