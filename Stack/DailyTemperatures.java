/*
 * https://leetcode.com/problems/daily-temperatures/submissions/1063265082/
 * https://leetcode.com/problems/daily-temperatures/description/
 * 739. Daily Temperatures
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

import java.util.*;

class DailyTemperatures {
    static void print(int[] array) {
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    static int[] findDailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int i;
        for (i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            if (stack.isEmpty())
                result[i] = 0;
            else
                result[i] = stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int temperatures[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int result[] = findDailyTemperatures(temperatures);
        print(result);
    }
}