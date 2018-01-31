package com.ivo.chapter3.item21;

/**
 *
 * @author IOAdmin
 */
public class StringLengthComparator implements Comparator<String>{

    @Override
    public int comparator(String t1, String t2) {
        return t1.length() - t2.length();
    }
    
    public static void main(String[] args) {
        String h1 = "hello";
        String h2 = "hello";
        System.out.println(new StringLengthComparator().comparator(h1, h2));
    }

}
