package Algorithm.OneToFifty;

/**
 * Description:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */

// TODO unfinished
public class A5LongestPalindromicSubstring {
    public static String longesrPalindrome(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int offset = 0;

        int result = 0;

        int medium = len / 2;
        if (len % 2 == 0) {
            result = palindromeEven(c, len, medium);
            System.out.println("even: " + result);
            return s.substring(len - result - 1, result + 1);

        } else {
            result = palindromOdd(c, len, medium);
            System.out.println("odd: " + result);
            return s.substring(result, len - result);
        }


    }

    private static int palindromeEven(char[] c, int len, int medium) {
        if (medium == 0 || medium == len - 1) {
            return 1;
        } else {
            int mid = medium - 1;
            int i = 0;

//            if (mid <)
        }



        if (medium < len && c[medium - 1] == c[len - medium - 1]) {
            medium ++;
        }
//        return (len / 2 - medium) * 2;
        System.out.println("返回的数据： " + medium);
        return medium;
    }

    private static int palindromOdd(char[] c, int len, int medium) {
        medium--;
        if (medium >= 1 && c[medium] == c[len - medium - 1]) {
            medium--;
        }

        return medium;
    }

    public static void main(String[] args) {
        System.out.println(longesrPalindrome("cbacabd"));
    }
}
