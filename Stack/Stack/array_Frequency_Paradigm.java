/*
You are given an array A of size N. For each of the indices i (1 <= i <= N), find the the smallest index j such that i < j and the frequency of Ai is lesser than or equal to that of Aj in the array.
Input
The first line of the input contains a single integer N.
The second line of the input contains N space seperated integers.

Constraints:
1 <= N <= 105
1 <= Ai <= 105
Output
For each of the indices i (1 <= i <= N), print the the smallest index j such that i < j and the frequency of Ai is lesser than or equal to that of Aj in the array. If there is no such index j, print -1 for that particular index i.
Example
Sample Input:
7
1 2 3 3 3 1 1

Sample Output:
3 3 4 5 6 7 -1

Explaination:
For,
i = 1, j = 3
i = 2, j = 3
i = 3, j = 4
i = 4, j = 5
i = 5, j = 6
i = 6, j = 7
i = 7, no such j exists
 */
package Stack;
import java.util.*;
class array_Frequency_Paradigm{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
        int a[] = new int[N];
        int i;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(i=0;i<N;i++){
            a[i] = sc.nextInt();
            int x = a[i];
            freq.put(x, freq.getOrDefault(x,0) + 1);
        }
        Stack<Integer> nextGreaterElement = new Stack<>();
        int result[] = new int[N];
        for(i=N-1;i>=0;i--){
            while(!nextGreaterElement.isEmpty()&&freq.get(a[i])>freq.get(a[nextGreaterElement.peek()])){
                nextGreaterElement.pop();
            }
            if(nextGreaterElement.isEmpty()){
                result[i] = -1;
            }
            else
                result[i] = nextGreaterElement.peek() + 1;
            
            nextGreaterElement.push(i);
        }
        for(i=0;i<N;i++)
            System.out.print(result[i]+" ");
        }
    }
}