/*
 You are given an array A of size N. Find the number of pairs of indices (i, j) in the array A such that i < j and Ai - i = Aj - j.
Input
The first line of the input contains a single integer N.
The second line of the input contains N space seperated integers.

Constraints:
1 <= N <= 105
1 <= Ai <= 105
Output
Print the number of pairs of indices (i, j) in the given array A such that i < j and Ai - i = Aj - j.
Example
Sample Input:
4
1 3 3 4

Sample Output:
3

Explaination:
The three pairs of indices are:
(1, 3) -> A[1] - 1 = A[3] - 3 -> 1 - 1 = 3 - 3 -> 0 = 0
(1, 4) -> A[1] - 1 = A[4] - 4 -> 1 - 1 = 4 - 4 -> 0 = 0
(3, 4) -> A[3] - 3 = A[4] - 4 -> 3 - 3 = 4 - 4 -> 0 = 0
 */

package Hashmap;
import java.util.*;
public class array_counting_problem {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long x;long count = 0; long value = 0;
            int i;
            HashMap<Long,Integer> freq = new HashMap<>();
            for(i=0;i<n;i++){
                x = sc.nextLong();
                value = x - (i+1);
                freq.put(value,freq.getOrDefault(value,0)+1);
                //System.out.println(value);
            }
            for(Map.Entry<Long,Integer> entry: freq.entrySet()){
                value = entry.getValue();
                if(value>1)
                    count+=((value)*(value-1))/2;
            }
            System.out.print(count);
        }
    }
}
