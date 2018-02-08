package com.ivo.chapter4.item26.secondtechnqiue;

import java.util.Arrays;

/**
 *
 * @author IOAdmin
 */
public class Stack<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
    
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        // push requires elements to be of type E, so cast is correct
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        
        elements[size] = null;
        return result;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    
    // Little program to exercise our generic Stack
	public static void main(String[] args) {
            Stack<String> stack = new Stack<String>();
            String[] args1 = new String[]{"a","b"};
            for (String arg : args1)
                    stack.push(arg);
            while (!stack.isEmpty())
                    System.out.println(stack.pop().toUpperCase());
	}
    
}
