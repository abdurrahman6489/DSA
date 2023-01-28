/*
 * You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i. e., if its value is '0' it becomes '1' and vice- versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
Input
There is a binary string s is given as input.

Constraints
1 <= s.length <= 105
s[i] is either '0' or '1'.
Output
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.
Example
Sample Input:
111000

Sample Output:
2

Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
 */
package SlidingWindow;
import java.util.*;
public class alternateString {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        String s = sc.next();
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        int i;
        for(i=0;i<n;i++){
            char c = s.charAt(i);
            if(i%2==0&&c=='0'){
                count1++;
            }
            if(i%2==0&&c=='1'){
                count2++;
            }
            if(i%2!=0&&c=='1'){
                count1++;
            }
            if(i%2!=0&&c=='0'){
                count2++;
            }
        }
        System.out.print(Math.min(count1,count2));
        }
    }
}
