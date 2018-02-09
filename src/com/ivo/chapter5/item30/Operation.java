package com.ivo.chapter5.item30;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author IOAdmin
 */
public enum Operation {

    PLUS("+") {
            double apply(double x, double y) {
                    return x + y;
            }
    },
    MINUS("-") {
            double apply(double x, double y) {
                    return x - y;
            }
    },
    TIMES("*") {
            double apply(double x, double y) {
                    return x * y;
            }
    },
    DIVIDE("/") {
            double apply(double x, double y) {
                    return x / y;
            }
    };
    
    private final String symbol;

    Operation(String symbol) {
            this.symbol = symbol;
    }

    @Override
    public String toString() {
            return symbol;
    }

    abstract double apply(double x, double y);

    // Implementing a fromString method on an enum type - Page 154
    private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();
    static { // Initialize map from constant name to enum constant
            for (Operation op : values())
                    stringToEnum.put(op.toString(), op);
    }

    // Returns Operation for string, or null if string is invalid
    public static Operation fromString(String symbol) {
            return stringToEnum.get(symbol);
    }

    // Test program to perform all operations on given operands
    public static void main(String[] args) {
            double x = 5;
            double y = 3;
            for (Operation op : Operation.values())
                    System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
    
}
