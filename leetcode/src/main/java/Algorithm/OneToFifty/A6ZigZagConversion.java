package Algorithm.OneToFifty;

import java.util.Arrays;

/**
 * Description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class A6ZigZagConversion {

    // wrong maybe I misunderstand the question.
    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int length = c.length;
        int numColums = length / numRows * 2 + 1;

        char[][] temp = new char[numRows][numColums];
        int row = 0;
        int colum = 0;

        for (int i = 0; i < length; i++) {
            temp[row][colum] = c[i];


            if (row == 0 || (colum + 1) % numRows == 0) {
                row++;
            } else if (row == numRows - 1 || (colum + 1) % numRows == 0) {
                row--;
                colum++;
            }
        }

//        System.out.println("nice " + temp[1][1]);

        StringBuilder builder = new StringBuilder();
        for (char[] rows : temp) {
            for (char val : rows) {
                if (Character.isLetter(val)) {
                    builder.append(val);
                }
            }
//            System.out.println("row: " + builder.toString());
        }

        return builder.toString();
//        return Arrays.deepToString(temp);

    }

    // reference: https://leetcode.com/problems/zigzag-conversion/#/solutions
    public static String convert2(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(c[i++]);
            }
        }

            for (int idx = 1; idx < sb.length; idx++) {
                sb[0].append(sb[idx]);
            }

            return sb[0].toString();

    }

    public static void main(String[] args) {
        System.out.println("enhen: " + convert("PAYPALISHIRING", 3));
        System.out.println("nice: " + convert("A", 2));
        System.out.println("nice： " + convert("ABC", 1));
        System.out.println("nice: " + convert("ABCD", 2));
        System.out.println("nice： " + convert("ABC", 2));
    }
}
