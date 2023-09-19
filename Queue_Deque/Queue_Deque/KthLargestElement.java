/*
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/1053733094/
 * Kth Largest Element in a Stream
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 */

import java.util.*;

class KthLargest {
    PriorityQueue<Integer> queue;
    int count;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        int i;
        count = k;
        int n = nums.length;
        if (n > 0) {
            if (n < count)
                for (i = 0; i < n; i++)
                    queue.add(nums[i]);
            else {
                for (i = 0; i < count; i++)
                    queue.add(nums[i]);
                for (; i < n; i++) {
                    if (nums[i] > queue.peek()) {
                        queue.remove();
                        queue.add(nums[i]);
                    }
                }
            }
        }
    }

    public int add(int val) {
        if (queue.isEmpty() || queue.size() < count) {
            queue.add(val);
            return queue.peek();
        }
        if (val > queue.peek()) {
            queue.remove();
            queue.add(val);
        }
        return queue.peek();
    }
}

public class KthLargestElement {
    public static void main(String[] args) {
        int k = 3;
        int nums[] = { 4, 5, 8, 2 };
        KthLargest obj = new KthLargest(k, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }
}
