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