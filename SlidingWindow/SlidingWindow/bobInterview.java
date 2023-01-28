/*
 * Bob applied for a company. There are N rounds of interview. He can predict the result of each rounds based on his skill and type of round. Result of each round was stored in a binary array "results". Where results[ i ] = 1 means he can clear that round otherwise not. For getting selected one has to clear at least ''X" round(s) of interview.

He has to select any K contiguous interview rounds which he wants to appear for. Selection decision will be made based on these rounds. Help bob find whether he can be selected or not.
Input
First line will be N, X, K, number of interview rounds, minimum number of interview(s) needed to be cleared for selection, and number of continuous interview Bob is going to appear.

Second line will have N space separated binary digits denoting predicted result of each round.

Constraints:
1 <= X <= K <= N<= 10^5
Output
Output "YES" if he can be selected for X- Company, "NO" otherwise.
Example
Input:
8 2 3
1 0 1 1 0 1 0 1

Output:
YES

Explanation :
Bob can appear for round 6, 7 and 8. He can clear 2 out of these three rounds.

Input:
8 3 3
1 0 1 1 0 1 0 1

Output:
NO

Explanation :
There is now way to select 3 interviews, so that bob can clear at least 3 rounds.
 */
package SlidingWindow;

import java.util.*;
public class bobInterview {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();
            int i;
            int a[] = new int[n];
            for(i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            int sum = 0;
            for(i=0;i<k;i++){
                sum+=a[i];
            }
            if(sum>=x){
                System.out.print("YES");
            }
            else{
                    for(i=k;i<n;i++){
                    sum = sum + a[i] - a[i-k];
                    if(sum>=x){
                        System.out.print("YES");
                        break;
                    }
                }
            }
            if(sum<x){
                System.out.print("NO");
            }
        }
    }
}
