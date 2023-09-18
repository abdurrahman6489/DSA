/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Given a string s, find the length of the longest 
substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class LongestSubstring {
    static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int leftIndex, rightIndex;
        int maxLength = 0;
        for (leftIndex = 0, rightIndex = 0; rightIndex < n; rightIndex++) {
            char c = s.charAt(rightIndex);
            int index = s.indexOf(c, leftIndex);
            if (index != rightIndex) {
                leftIndex = index + 1;
            }
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int LongestSubstringLength = lengthOfLongestSubstring(str);
        System.out.print(LongestSubstringLength);
    }
}