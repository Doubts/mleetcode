package Algorithm.OneToFifty;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not
 * see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 */
public class A8StringToInteger {

    // wrong: when inout "+-2" and the output should be 0, but I think it should be -2, so,
    // I misunderstand the question again.
    public static int myAtoi(String str) {
        char[] c = str.toCharArray();
        List<Character> result = new ArrayList<>();
        boolean isNagative = false;
        for (char val : c) {
            System.out.println(val + " " + result.size());
            if (val == '-' && result.size() == 0) {
                isNagative = true;
            }
            if (Character.isDigit(val)) {
                result.add(val);
            }
        }

        System.out.println(result.toString());

        long res = 0;
        if (result.size() == 0) {
            return 0;
        } else {
            for (char temp : result) {
                System.out.println("every position : " + temp);
                res = res * 10 + (temp - 48);
            }
        }
        System.out.println("the result is : " + res);

        System.out.println(isNagative);
        if (isNagative) {
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return -(int) res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;

    }


    // reference: https://leetcode.com/problems/string-to-integer-atoi/#/solutions
    public static int myAtoi2(String str) {
        int sign = 1, index = 0, total = 0;
        if (str.length() == 0) return 0;

//        System.out.println(str.length());
        while (index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index < str.length()) {
            if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                sign = str.charAt(index) == '+' ? 1 : -1;
                index++;
            }

            while (index < str.length()) {
                int digit = str.charAt(index) - '0';
                if (digit < 0 || digit > 9) {
                    break;
                }

                if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                total = 10 * total + digit;
                index++;
            }
        }

        return total * sign;


    }


    public static void main(String[] args) {
        String[] test = {"", "12", "er", "se4", "-1", "   " };
        for (String str : test) {
            System.out.println(myAtoi2(str));
        }
    }

}
