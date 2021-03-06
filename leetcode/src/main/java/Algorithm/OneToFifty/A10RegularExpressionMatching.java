package Algorithm.OneToFifty;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Implement regular expression matching with support for '.' and '*'.

 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.

 * The matching should cover the entire input string (not partial).

 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)

 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class A10RegularExpressionMatching {
//    public static boolean isMatch(String s, String p) {
//
//    }

    private static boolean pointHelper(char c) {
        return Character.isLetter(c);
    }
}
