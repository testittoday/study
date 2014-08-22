/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhan.string.nonRepeatChar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 1. Write a function to return the first non repeated character in a string
 * 
 * For example, in the case of "HelloWorld", it should return 'H'
 * 
 * 2. Write a function to Count total number of times each alphabet appears in the string
 * 
 * For example, in the case of "HelloWorld", it will return "H1e1l3l3o2W1o2r1l3d1"
 * 
 * @author mzhan
 */
public class FirstNonRepeatChar {

    public static char findFirstNonRepeatChar(String s) {
        // hash map that hold k-v pair that key is char and value is this char's occurrence number
        Map<Character, Integer> map = new HashMap<>();
        
        char result = '0';
        
        if(s == null || s.isEmpty()) {
            return result;
        }
        
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int tmp = map.get(c);
                map.put(c, tmp + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (int k = 0; k < len; k++) {
            char c = s.charAt(k);
            if (map.get(c) == 1) {
                result = c;
                break;
            }
        }
        return result;
    }
    
    public static String findCharOccurenceNum(String s) {
        // hash map that hold k-v pair that key is char and value is this char's occurrence number
        Map<Character, Integer> map = new HashMap<>();
        
        String result = null;
        
        if(s == null || s.isEmpty()) {
            return result;
        }
        
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int tmp = map.get(c);
                map.put(c, tmp + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++) {
            char c = s.charAt(k);
            int v = map.get(c);

            sb.append(c).append(v);
        }
        return result = sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "Hello World";
//        String s = "stress";
//        String s = "teeter";
        System.out.println("the first non-repeat char of " + s + " = "
                + FirstNonRepeatChar.findFirstNonRepeatChar(s));
        System.out.println("the char occurence number of " + s + " = "
                + FirstNonRepeatChar.findCharOccurenceNum(s));
        
        // easy way to get string to be tested
//        System.out.println(" Please enter the input string :" );
//        Scanner in = new Scanner (System.in);
//        String ss =in.nextLine();
//        char c = findFirstNonRepeatChar(ss);
//        System.out.println("The first non repeated character is :  " + c);

 
    }
    
}
