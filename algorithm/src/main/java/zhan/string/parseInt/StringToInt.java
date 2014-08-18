/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package zhan.string.parseInt;

/**
 *
 * Write method to convert String to int without using Java Integer.parseInt(String) method
 * 
 * for example, input string is "123456", expected result is int 123456
 *
 * we assume the input is only digit string, then we save code to throw NumberFormatException
 * 
 * To convert string to integer, first we need to know what place value 
 * each digit must be multiplied by.
 * 
 * scan string from left to right
 * time radix 10 in each round of loop
 * a little char to int conversion, and '1' - '0' to int trick
 *
 * @author mzhan
 */
public class StringToInt {
    
    public static void main (String args[]) {
        String convertingString = "-123456";
        System.out.println("String Before Conversion :  "+ convertingString);
        int output = stringToInt(convertingString);
        System.out.println("int value as output "+ output);
    }
    
    public static int stringToInt(String str) {
        int i = 0, number = 0;
        boolean isNegative = false;
        int len = str.length();
        if (str.charAt(0) == '-') {
            isNegative = true;
            i = 1;
        }
        while (i < len) {
            number *= 10;
            number += (str.charAt(i++) - '0');

            // here is the details of above line 35
//            char c = (str.charAt(i++)); // str = "123456", i = 0, then c = '1'
//            int k = (int) c; // widen from char to int, k = 49, no info will miss
//            int cc = c - '0'; // '0' ascii code is 48, so '1' - '0' has result of int cc = 1
//            number += cc; // number = 0 + cc = 1

            /**
             * Other than do the char to int casting, the following methods in
             * Character.java can be used to convert char to int
             * 
             * public static int getNumericValue(char ch)
             * 
             * public static int digit(char ch, int radix)
             * 
             */
        }
        if (isNegative) {
            number = -number;
        }
        return number;
    }
    
    
}
