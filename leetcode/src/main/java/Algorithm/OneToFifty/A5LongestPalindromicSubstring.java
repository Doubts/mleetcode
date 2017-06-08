package Algorithm.OneToFifty;

/**
 * Description:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */

public class A5LongestPalindromicSubstring {

    // wrong
    public static String longesrPalindrome(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int offset = 0;

        int result = 0;

        int medium = len / 2;
        if (len % 2 == 0) {
            result = palindromeEven(c, len, medium);
            return s.substring(len - result - 1, result + 1);

        } else {
            result = palindromOdd(c, len, medium);
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
        return medium;
    }

    private static int palindromOdd(char[] c, int len, int medium) {
        medium--;
        if (medium >= 1 && c[medium] == c[len - medium - 1]) {
            medium--;
        }

        return medium;
    }


    // reference: http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
    // traversal
    // beats 40%
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);

            if (temp.length() > longest.length()) {
                longest = temp;
            }

            temp = helper(s, i, i+1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
         }

        return longest;
    }

    private static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        return s.substring(begin + 1, end);
    }



    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbacabd"));
    }
}
