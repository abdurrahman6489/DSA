/*
 * https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1070266328/
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 * Given a binary array nums and an integer k, return the maximum number of consecutive 
 * 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

class MaxConsecutiveones3 {

    static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int zeros = 0;
        int max = 0;
        for (right = 0; right < n; right++) {
            if (nums[right] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int result = longestOnes(nums, k);
        System.out.println(result);
    }
}