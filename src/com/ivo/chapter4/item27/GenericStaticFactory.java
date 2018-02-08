package com.ivo.chapter4.item27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author IOAdmin
 */
public class GenericStaticFactory {

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }
    
    public static void main(String[] args) {
        Map<String, List<String>> m = newHashMap();
        
        List<String> l = new ArrayList<>();
        l.add("!");
        m.put("1", l);
        System.out.println(m.get("1"));
    }
    
}
