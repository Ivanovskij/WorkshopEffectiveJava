package com.ivo.chapter1.creatingAndDestroyingObjects;

/**
 *
 * @author IOAdmin
 */
public class AvoidCreatingUnnecessaryObjects {

    public static void lowSum() {
        Long sum = 0L;
        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        
        long time = endTime - startTime;
        System.out.println(time + " ms.");
        
        System.out.println(sum);
    }
    
    public static void highSum() {
        long sum = 0L;
        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        
        long time = endTime - startTime;
        System.out.println(time + " ms.");
        
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
        lowSum();
        highSum();
    }
    
}
