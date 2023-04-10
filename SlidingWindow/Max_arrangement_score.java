/*
 There are N numbers arranged in a queue. Score of the arrangement is defined as the sum of first K numbers of the queue.
You can remove one number from the front of the queue and move it to the end of the queue. You can do this as many times as you want. What is the maximum score of any arrangement you can achieve?
Input
First line contains N and K.
Next line contains N space separated integers denoting the current arrangement of the queue.

Constraints
1 ≤ K ≤ N ≤ 105
1 ≤ arr[i] ≤ 109
Output
Print a single integer denoting the maximum score of any arrangement.
Example
Input:
6 3
2 5 6 2 6 1

Output:
14

Explanation:
initial => 2 5 6 2 6 1 => score = 2 + 5 + 6 = 13
1st operation => 5 6 2 6 1 2 => score = 5 + 6 + 2 = 13
2nd operation => 6 2 6 1 2 5 => score = 6 + 2 + 6 = 14
 */


import java.util.*;
public class Max_arrangement_score {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = n+k-1;
            long a[] = new long[m];
            long sum = 0;
            long max = Integer.MIN_VALUE;
            int i;
            for(i=0;i<n;i++){
                a[i] = sc.nextLong();
            }
            for(i=n;i<m;i++){
                a[i] = a[i-n];
            }
            for(i=0;i<k;i++){
                sum+=a[i];
            }
            for(i=k;i<m;i++){
                sum+=a[i]-a[i-k];
                max=Math.max(max,sum);
            }
            System.out.print(max);
        }
    }
}
