/*
You are given an array arr of size n and a window of size k your task is to find that whether two adjacent windows sum can be equal to the given sum. If yes print "YES" otherwise print "NO".
Input
The first line of the input contains n, k and sum.
Second line of the input contains the array arr.

Constraints
1 <= k < n <= 1e4
1 <= sum <= 1e8
1 <= arr[i] <= 1e3
Output
Print "YES" if the sum exists otherwise "NO".
Example
Sample Input 1:
5 3 21
1 2 4 3 5

Sample Output 1:
YES
 */
package SlidingWindow;

import java.util.*;

class adjacentWindowSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long sum = sc.nextLong();
            long cur_sum = 0;
            long prev_sum = 0;
            int i;
            int a[] = new int[n];
            for (i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (i = 0; i < k; i++) {
                cur_sum += a[i];
            }
            for (i = k; i < n; i++) {
                prev_sum = cur_sum;
                cur_sum = cur_sum + a[i] - a[i - k];
                if (prev_sum + cur_sum == sum) {
                    System.out.print("YES");
                    break;
                }
            }
            if (prev_sum + cur_sum != sum) {
                System.out.print("NO");
            }
        }
    }
}