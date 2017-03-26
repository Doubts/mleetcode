package Algorithm.OneToFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 */
public class A3LongestSubstringWithoutRepeatingCharacters {

    // beats 15%
    public static int lengthOfLongestSubstring(String s) {
        char[] s1 = s.toCharArray();
        char[] s2 = s.toCharArray();
        int point1 = 0,  point2 = 0;
        int result = point1 - point2;
        List<Character> clist = new ArrayList<>();
        for (; point1 < s.length(); point1++) {
            if (clist.contains(s1[point1])) {
                for (int i = point2; i < point1; i++) {
                    if (s2[i] == s1[point1]) {
                        point2 = i + 1;
                    }
                }
                clist.clear();
                for (int j = point2; j <= point1; j++) {
                    clist.add(s2[j]);
                }
            } else {
                clist.add(s1[point1]);
                result = Math.max(result, clist.size());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("c") );
        System.out.println(lengthOfLongestSubstring("abcabcabc") );
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("nfpdmpi"));
    }
}
