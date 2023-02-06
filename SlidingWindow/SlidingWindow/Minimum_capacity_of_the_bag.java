/*
 There are N coins arranged in a row. Each coin has some values denoted by the array val where vali is value of the ith coin, 1 ≤ i ≤ N.
Bob wants to collect some continuous set of coins so that the total value of all coins is at least X . Bob collects coins in a bag which has limited capacity and to get bag with more capacity the cost is more.
Capacity of the bag is defined as the number of coins it can store.
Bob wants to know the minimum capacity of bag which he can use to collect coins and achieve the target X.
Input
First line contains N and X.
Next line contains N space separated integers.

Constraints
1 ≤ N ≤ 105
1 ≤ val[i] ≤ 109
1 ≤ X ≤ sum of all coins
Output
A single integer denoting the minimum capacity of the bag.
Example
Input:
6 9
4 1 8 3 3 7

Output:
2

Explanation:
He can take a bag with capacity 2 and collect coins { 3, 4 }.
Total value = 8 + 3 = 11 ≥ 9
 */
package SlidingWindow;

import java.util.*;
class Minimum_capacity_of_the_bag{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
        long a[] = new long[n];
        long x = sc.nextLong();
        int i=0,j=0;
        for(i=0;i<n;i++){
            a[i] = sc.nextLong();
        }
        long sum = 0;
        int min_size = n;
        i=0;
        while(j<n){
            if(sum<x&&j<n){
                sum+=a[j];
                j++;
                //System.out.println("sum is "+sum+" j is "+j);
            }
            else{
                min_size = Math.min(min_size,j-i);
                //System.out.println("minsize is "+min_size);
                sum-=a[i];
                //System.out.println("sum is "+sum);
                //System.out.println("i is "+i);
                i++;
                //System.out.println("i is "+i);
            }
            // System.out.println("j is "+j);
            // j++;
            // System.out.println("j is "+j);
            
        }
        System.out.print(min_size);
            
        }
    }
}