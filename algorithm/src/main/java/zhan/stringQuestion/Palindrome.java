/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package zhan.stringQuestion;

/**
 * Write a function to check if a string is palindrome or not
 * 
 * get 2 solution idea from Internet:
 * 
 * One solution idea: palindrome string's reverse string are equal
 * 
 * Another idea:  
 *                   compare 1st char with last char
 *                   compare 2nd char with 2nd to last char
 *                   compare 3rd char with 3rd to last char
 *                   ......
 *                   until reach the char at middle position
 * 
 *                   if any of the above comparison return false
 *                   then it is not palindrome immediately
 * 
 * @author mzhan
 */
public class Palindrome {
    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        return strBuilder.toString().equals(str);
    }

    public static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
        System.out.println("in isPalindromeString: length = " + length 
                + " length / 2 = " + length / 2);
        for (int i = 0; i < length / 2; i++) {
            
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("is 123421 palindrome? aws = " + isPalindrome("123421"));
        System.out.println("is 12321 palindrome? aws = " + isPalindromeString("12321"));
    }
}
