/*
 https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 2610. Convert an Array Into a 2D Array With Conditions

 You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.

Example 2:

Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 */

import java.util.*;

class arrayInto2DArray {
    static List<List<Integer>> findMatrix(int nums[]) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        List<Integer> list1 = new LinkedList<>();
        result.add(list1);
        int currentRow = 0;
        int listIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                List<Integer> list2;
                currentRow = result.size() - 1;
                listIndex = map.get(num);
                if (currentRow < listIndex) {
                    list2 = new LinkedList<>();
                    result.add(list2);
                } else
                    list2 = result.get(listIndex);
                list2.add(num);
                map.put(num, listIndex + 1);
            } else {
                List<Integer> list3 = result.get(0);
                list3.add(num);
                map.put(num, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 4, 1, 2, 3, 1 };
        // int nums[] = { 1, 2, 3, 4 };
        List<List<Integer>> result = findMatrix(nums);
        System.out.println(result.toString());
    }
}
