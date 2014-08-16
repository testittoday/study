/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zhan.wordPhonePadMapping;

/**
 *
 * @author mzhan
 */
public class PhonePadUtil {
    /**
     * 
     * Phone pad char and digit mapping rules
     * from: http://en.wikipedia.org/wiki/Telephone_keypad
     * 
     * 0 = none (in some telephones, "OPERATOR" or "OPER")
     * 1 = none (in some older telephones, QZ)
     * 2 = ABC
     * 3 = DEF
     * 4 = GHI
     * 5 = JKL
     * 6 = MNO
     * 7 = PQRS (in some older telephones, PRS)
     * 8 = TUV
     * 9 = WXYZ (in some older telephones, WXY)
     *
     * @param letter
     * @return
     */
    public static int charToPhoneDigit (final char letter)
    {
        final char c = Character.toUpperCase(letter);
        int value = 0;

        switch(c) {
            case 'A':
            case 'B':
            case 'C':
                value = 2;
                break;

            case 'D':
            case 'E':
            case 'F':
                value = 3;
                break;

            case 'G':
            case 'H':
            case 'I':
                value = 4;
                break;

            case 'J':
            case 'K':
            case 'L':
                value = 5;
                break;

            case 'M':
            case 'N':
            case 'O':
                value = 6;
                break;

            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                value = 7;
                break;

            case 'T':
            case 'U':
            case 'V':
                value = 8;
                break;

            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                value = 9;
                break;

        }
        return value;

    }
    
}
