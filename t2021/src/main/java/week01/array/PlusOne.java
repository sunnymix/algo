package week01.array;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    public static void main(String[] args) {
        Print.array(plusOne(new int[]{1, 2, 3}));
        Print.array(plusOne(new int[]{9}));
        Print.array(plusOne(new int[]{9, 9, 9}));
    }

    public static int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (carry) {
                digit++;
            }
            if (digit >= 10) {
                digit = digit % 10;
                carry = true;
            } else {
                carry = false;
            }
            if (digit != digits[i]) digits[i] = digit;
        }
        if (carry) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }
}
