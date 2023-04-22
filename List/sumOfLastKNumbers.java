/*
 Problem Statement
Given an integer Q representing the number of queries and an integer K. There are two types of queries:
(i) 1 x : Add the number x to the stream
(ii) 2 : Print the sum of last K numbers of the stream. If there are less than K numbers in the stream, print the sum of current stream.
Process all the queries.
Input
First line contains two integers Q and K.
Next Q lines contains the queries.

Constraints
1 <= Q <= 10^5
1 <= x <= 10^5
1 <= K <= Q
There is atleast one query of 2nd type.
Output
For each query of type 2, print the sum of last K numbers of the stream on a new line.

Example
Sample Input 1:
5 2
1 4
2
1 1
1 3
2

Output
4
4

Explanation:
Initial Stream = {}
Add 4. Stream = {4}
Sum of last two elements = 4
Add 1. Stream = {4, 1}
Add 3. Stream = {4, 1, 3}
Sum of last two elements = 4
 */

import java.util.*;

public class sumOfLastKNumbers {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int q = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>();
            int i;
            long currentSum = 0L;
            long lastSum = 0L;
            int x = 0;
            int queryType = 0;
            for (i = 0; i < q; i++) {
                queryType = sc.nextInt();
                if (queryType == 1) {
                    x = sc.nextInt();
                    currentSum += x;
                    list.add(currentSum);
                } else if (queryType == 2) {
                    if (list.size() <= k)
                        System.out.println(currentSum);
                    else {
                        lastSum = list.get(list.size() - 1 - k);
                        System.out.println(currentSum - lastSum);
                    }
                }
            }
        }
    }
}
