package Algorithm.OneToFifty;

import java.util.Arrays;

/**
 * Description:
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 * Subscribe to see which companies asked this question.
 */
public class A7ReverseInteger {

    // only beats 1.6%; when I use long instead Long, time improve 12ms, beats 5%
    public static int reverse(int x) {
        long temp = Math.abs((long)x);
        System.out.println(temp);
        char[] val = String.valueOf(temp).toCharArray();

        System.out.println(Arrays.toString(val));

        StringBuilder builder = new StringBuilder();
        for (int i = val.length - 1; i >= 0; i--) {
            builder.append(val[i]);
        }

//        Long res = Long.parseLong(builder.toString());
        long res = Long.parseLong(builder.toString());


//        return x > 0? (int) (long) res : -(int) (long) res;
        return x > 0? (int) res : -(int) res;
    }

    // beats 50% reference: https://leetcode.com/problems/reverse-integer/#/solutions
    public static int reverse2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result ) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
