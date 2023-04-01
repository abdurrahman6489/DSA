/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/ 
81. Search in Rotated Sorted Array II
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */
class RotatedSortedArrayII {
    static boolean binarySearch(int array[], int target){
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while(lowIndex <= highIndex){
            int midIndex = lowIndex + (highIndex - lowIndex)/2;
            if(array[midIndex] == target) return true;
            if(array[lowIndex] == array[midIndex] && array[midIndex] == array[highIndex]){
                lowIndex+=1;
                highIndex-=1;
            }
            else if(array[lowIndex] <= array[midIndex]){
                if(array[lowIndex]<= target && target < array[midIndex])
                    highIndex = midIndex - 1;
                else
                    lowIndex = midIndex + 1;
            }
            else{
                if(target > array[midIndex] && target <= array[highIndex])
                    lowIndex = midIndex + 1;
                else
                    highIndex = midIndex - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {2,5,6,0,0,1,2};
        int target = 8;
        System.out.print(binarySearch(nums, target));
    }
}
