/*
2342. Max Sum of a Pair With Equal Sum of Digits
https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 */
class maxSumPairEqualDigits{
    static int findDigitSum(int number){
        int digit = 0; int sum = 0;
        while(number>0){
            digit = number%10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }
    public static void main(String[] args){
        int nums[] = {18,43,36,13,7};
        int digitArray[][] = new int[82][2];
        int i; int digitSum = 0; int result = -1;
        for(int x : nums){
            digitSum = findDigitSum(x);
            if(digitArray[digitSum][0] == 0) digitArray[digitSum][0] = x;
            else{
                if(x>digitArray[digitSum][0]){
                    digitArray[digitSum][1] = digitArray[digitSum][0];
                    digitArray[digitSum][0] = x;
                }
                else if(x>digitArray[digitSum][1]) digitArray[digitSum][1] = x;
            }
        }
        for(i = 81; i>=0; i--){
            if(digitArray[i][1]>0){
                result = Math.max(result, digitArray[i][1] + digitArray[i][0]);
            }
        }
        System.out.print(result);
    }
}