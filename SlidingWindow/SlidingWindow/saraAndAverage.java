/*
 * Sara wants to be the best programmer in the world. To help Sara her friend Rahul gave her a problem:-
Rahul gave Sara a stream of integers of size N and ask if she can give the average for every window of size W.. If the stream has lesser element than W then print the average of those integers.
Input
First line of input contains the size of stream N and the window size W. Next line contains N space-separated integers denoting the stream.

Constraints:-
1 <= W <= N <= 100000
1 < element <= 100000
Output
Print N elements separated by spaces the floor of average of window as shown in example.
Example
Sample Input:-
5 3
1 2 3 4 5

Sample Output:-
1 1 2 3 4

Explanation:-
1/1 = 1
(1 + 2) / 2 = 1
(1 + 2 + 3)/ 3 = 2
(2 + 3 + 4) /3 = 3
(3 + 4 + 5)/ 3 = 4
 */
package SlidingWindow;

import java.util.*;
public class saraAndAverage {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
        int K = sc.nextInt();
        int a[] = new int[N];
        int i;
        long sum = 0;
        long avg = 0;
        for(i = 0; i<N; i++){
            a[i] = sc.nextInt();
        }
            for(i=0;i<K;i++){
                sum+=a[i];
                avg = sum/(i+1);
                System.out.print(avg+ " ");
            }
            for(i=K;i<N;i++){
                sum+=a[i];
                sum-=a[i-K];
                avg = sum/K;
                System.out.print(avg+ " ");
            }
        }
    }
}
