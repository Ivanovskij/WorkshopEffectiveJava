package com.ivo.chapter3.item17;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Super {
    // Broken - constructor invokes an overridable method
    public Super() {
        ovverideMe();
    }

    protected void ovverideMe() {
    }
}

class Sub extends Super {
    
    private final Date date;    // Blank final, set by constructor
    
    Sub() {
        date = new Date();
    }

    // Overriding method invoked by superclass constructor
    @Override
    protected void ovverideMe() {
        System.out.println(date);
    }

    
}

class DesignAndDocumentForInheritanceOrElseProhibitItApp {

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.ovverideMe();
        
        List a = new ArrayList<>();
    }
    
}
