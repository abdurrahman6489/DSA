/*
 * 
 * https://leetcode.com/problems/trapping-rain-water/description/
 * https://leetcode.com/problems/trapping-rain-water/submissions/1052863676/
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */

class TrappingRainWater {
    static int trap(int[] height) {
        int n = height.length;
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        int result = 0;
        int i;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        for (i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[n - i - 1]);
            prefixArray[i] = leftMax;
            suffixArray[n - i - 1] = rightMax;
        }
        for (i = 0; i < n; i++)
            result += Math.abs(Math.min(prefixArray[i], suffixArray[i]) - height[i]);
        return result;
    }

    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = trap(height);
        System.out.print(result);
    }
}