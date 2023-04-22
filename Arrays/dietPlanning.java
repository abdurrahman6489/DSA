/*
 There are N chocolates with you. You want to finish them as quickly as possible, but recently you've gained a lot of weight and hence you've set a limit for yourself on the number of chocolates you can eat per day. This limit is different for each day i. e., for Monday it is a1, for Tuesday it is a2 and so on till Sunday as a7. Find the day on which you will eat your last chocolate starting with Monday.
Input
The first line of the input contains a single integer N.
The next line of the input contains 7 space seperated integers.

Constraints:
1 <= N <= 105
0 <= ai <= 105
Sum of all ai is greater than 0.
Output
Print the day on which you will eat your last chocolate.

Example
Sample Input:
15
2 4 3 1 0 0 1

Sample Output:
Tuesday
 */

import java.util.*;

public class dietPlanning {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long n = sc.nextLong();
            int arrayOfChocolates[] = new int[7]; // this is the no of chocolates eaten on each weekday
            int i;
            long currentSum = 0L;
            for (i = 0; i < 7; i++) {
                arrayOfChocolates[i] = sc.nextInt();
                currentSum += arrayOfChocolates[i];
            }
            String daysname[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
            i = 0;
            n = n % currentSum;
            while (n > 0)
                n -= arrayOfChocolates[i++];
            System.out.print(daysname[i - 1]);
        }

    }
}
