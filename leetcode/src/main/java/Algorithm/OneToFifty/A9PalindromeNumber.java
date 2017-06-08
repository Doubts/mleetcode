package Algorithm.OneToFifty;

import java.util.Arrays;

/**
 * Description:
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class A9PalindromeNumber {

    // beats 10%, but the
    public static boolean isPalindrome(int x) {
        if (x < 0 && x >= -10 ) return false;
        if (x == -2147483648) return false;
        return x == helper(x);
    }
    public static int helper(int x) {
        int sign = x > 0 ? 1 : -1;
        if (sign == -1) {
            x = -x;
        }
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            char temp = c[i];
            c[i] = c[s.length() - 1 - i];
            c[s.length() - 1 - i] = temp;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            builder.append(c[i]);
        }

        System.out.println(builder.toString());
//        System.out.println("reverse: " + Integer.parseInt(builder.toString()));
        if (Long.parseLong(builder.toString()) > Integer.MAX_VALUE) {
            return 0;
        } else {
            return sign * Integer.parseInt(builder.toString());
        }
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(-1));
//        System.out.println(isPalindrome(1));
//        System.out.println(isPalindrome(2));
        System.out.println(isPalindrome(-2147483648));
        System.out.println(isPalindrome(102));
        System.out.println(isPalindrome(2147483647));
    }
}
