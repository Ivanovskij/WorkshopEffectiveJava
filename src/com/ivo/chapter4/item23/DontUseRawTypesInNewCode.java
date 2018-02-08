package com.ivo.chapter4.item23;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IOAdmin
 */
public class DontUseRawTypesInNewCode {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings, new Integer(42));
        String s = strings.get(0);  // Compiler-generated cast, error
        //String s1 = String.valueOf(strings.get(0)); // not error cast
        
        // ----------------------------
        // Test.java:5: unsafeAdd2(List<Object>, Object o) cannot be applied
        // to (List<String>,Integer)
        //unsafeAdd2(strings, s); 
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
    
    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }
    
}
