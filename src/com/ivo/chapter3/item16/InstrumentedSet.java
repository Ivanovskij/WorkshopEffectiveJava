package com.ivo.chapter3.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author IOAdmin
 */
public class InstrumentedSet<E> extends ForwardingSet<E>{

    private int addCount = 0;
    
    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    
    public int getAddCount() {
        return addCount;
    }
    
    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<>(
            new HashSet<>());
        s.addAll(Arrays.asList("Snack", "Crack", "pop"));
        System.out.println(s.getAddCount());
    }
    
}
