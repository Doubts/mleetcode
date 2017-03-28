package Algorithm.OneToFifty;

/**
 * Description:
 */
public class A11ContainerWithMostWater {

    // Time Limit Exceeded
    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] >= height[j]) {
                    result = Math.max(height[j] * (j - i), result);
                } else {
                    result = Math.max(height[i] * (j - i), result);
                }
            }
        }

        return result;
    }

    // Time Limit
    public static int maxArea1(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int maxDistance = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] <= height[j]) {
                    maxDistance = j - i;
                }
            }

            for (int j = 0; j < i; j++) {
                if (height[j] >= height[i]) {
                    maxDistance = Math.max(i - j, maxDistance);
                    System.out.println("sb" + maxDistance);
                }
            }
            result = Math.max(height[i] * maxDistance, result);
        }
        System.out.println("result: " + result);
        return result;
    }

    // reference: https://leetcode.com/submissions/detail/98311674/
    // beats 14%
    public static int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(maxArea(new int[] {1,1}));
//        System.out.println(maxArea1(new int[] {2,1}));
        System.out.println(maxArea2(new int[]{2, 1}));
        System.out.println(maxArea2(new int[]{6, 9, 5, 3}));
    }
}
