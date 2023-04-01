/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
package BinarySearch;
import java.util.*;
class findFirst {
    static int searchLeft(int array[], int k){
        int firstIndex = -1;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while(lowIndex<=highIndex){
            int midIndex = lowIndex + (highIndex - lowIndex)/2;
            if(k<=array[midIndex])
                highIndex = midIndex - 1;
            else
                lowIndex = midIndex + 1;
            if(array[midIndex]==k)
                firstIndex = midIndex;
        }
        return firstIndex;
    }
    static int searchRight(int array[], int k){
        int lastIndex = -1;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while(lowIndex<=highIndex){
            int midIndex = lowIndex + (highIndex - lowIndex)/2;
            if(k>=array[midIndex])  
                lowIndex = midIndex + 1;
            else
                highIndex = midIndex - 1;
            if(array[midIndex]==k)
                lastIndex = midIndex;
        }
        return lastIndex;
    }
    public static void main(String[] args){
        int array[] = {5,7,7,7,8,8,8,10};
        int k = 8;  //target
        int result[] = new int[2];
        int firstIndex = searchLeft(array,k);
        int lastIndex = searchRight(array,k);
        result[0] = firstIndex;
        result[1] = lastIndex;
        System.out.print("The resultant array is "+ Arrays.toString(result));
    }
}
