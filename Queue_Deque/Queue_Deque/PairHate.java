/*
 Given a string S you have to remove all pairs of identical letters, which are consecutive. If after the removal there appear new pairs, remove them as well. Repeat this untill no adjacent letter in the string is same.
Note that deleting of the consecutive identical letters can be done in any order, as any order leads to the same result.
Input
The input data consists of a single string S.

Constraints:
1 <= |S| <= 100000
S contains lowercase english letters only.

Output
Print the given string after it is processed. It is guaranteed that the result will contain at least one character.

Example
Sample Input
hhoowaaaareyyoouu

Sample Output
wre

Explanation:
First we remove "hh" then "oo" then "aa" then "yy" then "oo" then "uu" and we are left with "wre".
Now we cannot remove anything.
 */

import java.util.*;

class PairHate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // String str = sc.nextLine();
            String str = "hhoowaaaareyyoouu";
            int n = str.length();
            Deque<Character> deque = new ArrayDeque<>();
            int i = 0;
            while (i < n) {
                if (!deque.isEmpty() && deque.peekLast().equals(str.charAt(i))) {
                    deque.removeLast();
                } else
                    deque.addLast(str.charAt(i));
                i++;
            }
            while (!deque.isEmpty())
                System.out.print(deque.removeFirst());
        }
    }
}