
/*
 https://leetcode.com/problems/count-number-of-bad-pairs/
 2364. Count Number of Bad Pairs
 You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

 Return the total number of bad pairs in nums.
 Example 1:

Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 0
Explanation: There are no bad pairs.
 */
import java.util.*;
class NumberOfBadPairs {
    public static void main(String[] args) {
        int nums[] = { 4, 1, 3, 3 };
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int i;
        long count = 0;
        for (i = 0; i < n; i++) {
            int previous = frequencyMap.getOrDefault(i - nums[i], 0);
            count += previous;
            frequencyMap.put(i - nums[i], previous + 1);
        }
        System.out.print(1L * n * (n - 1) / 2 - count);
    }
}