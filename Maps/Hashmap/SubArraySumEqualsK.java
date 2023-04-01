/*
https://leetcode.com/problems/subarray-sum-equals-k/description/
560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Example 1:

Input: nums = [1,2,3], k = 3
Output: 2
 */
import java.util.*;
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1};
        int k = 2;
        int n = nums.length;
        int currentSum = 0;
        int i;
        int count = 0;
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(i=0; i<n; i++){
            currentSum += nums[i];
            if(currentSum == k) count++;
            count += frequencyMap.getOrDefault(currentSum - k, 0);
            frequencyMap.put(currentSum, frequencyMap.getOrDefault(currentSum,0)+1);
        }
        System.out.print(count);
    }
}
