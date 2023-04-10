/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 974. Subarray Sums Divisible by K
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
 Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:

Input: nums = [5], k = 9
Output: 0
 */
import java.util.*;
class subArraySumDivisibleByK {
    public static void main(String[] args) {
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        int n = nums.length;
        int count = 0;
        int currentSum = 0;
        int remainder = 0; int i; int frequency = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(i=0;i<n;i++){
            currentSum += nums[i];
            remainder = currentSum % k;
            if(remainder<0) remainder += k;
            if(!map.containsKey(remainder)) map.put(remainder,1);
            else{
                frequency = map.get(remainder);
                count += frequency;
                map.put(remainder,frequency+1);
            }
        }
        System.out.print(count);
    }

}
