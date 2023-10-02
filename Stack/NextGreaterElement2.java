/*
 * https://leetcode.com/problems/next-greater-element-ii/submissions/1065164117/
 * https://leetcode.com/problems/next-greater-element-ii/description/
 * 503. Next Greater Element II
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] 
 * is nums[0]), return the next greater number for every element in nums.
 * The next greater number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 */

import java.util.*;

class NextGreaterElement2 {
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int i;
        int newLength = 2 * n;
        int array[] = new int[newLength];
        for (i = 0; i < newLength; i++)
            array[i] = nums[i % n];
        Stack<Integer> stack = new Stack<>();
        int greaterElements[] = new int[n];
        for (i = newLength - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[stack.peek()] <= array[i])
                stack.pop();
            if (stack.isEmpty() && i < n)
                greaterElements[i] = -1;
            else if (!stack.isEmpty() && i < n)
                greaterElements[i] = array[stack.peek()];
            stack.push(i);
        }
        return greaterElements;
    }

    static void print(int array[]) {
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 3 };
        int result[] = nextGreaterElements(array);
        print(result);
    }
}