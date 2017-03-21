package Algorithm.OneToFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class A1TwoSum {
    /** beats 32%
     * time complexity: O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // Use for traversal can resolve, but time is more long
        int i = 0;
        int j;
        for (; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * reference method: https://leetcode.com/problems/two-sum/#/solutions
     * Time complexity: O(n)
      */
    // beats 57%
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A1TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new A1TwoSum().twoSum(new int[]{5, 75, 25}, 100)));
        System.out.println(Arrays.toString(new A1TwoSum().twoSum(new int[]{0, 4, 3, 0}, 0)));

        System.out.println(Arrays.toString(new A1TwoSum().twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new A1TwoSum().twoSum2(new int[]{5, 75, 25}, 100)));
        System.out.println(Arrays.toString(new A1TwoSum().twoSum2(new int[]{0, 4, 3, 0}, 0)));
    }
}
