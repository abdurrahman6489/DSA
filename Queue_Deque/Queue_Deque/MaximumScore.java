import java.util.*;

class MaximumScore {
    static int findMaximumScore(int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(a);
        queue.add(b);
        queue.add(c);
        int first = 0;
        int second = 0;
        int score = 0;
        while (queue.size() > 1) {
            if (!queue.isEmpty())
                first = queue.remove();
            if (!queue.isEmpty())
                second = queue.remove();
            score++;
            if (first > 1)
                queue.add(first - 1);
            if (second > 1)
                queue.add(second - 1);
        }
        return score;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        int c = 6;
        int result = findMaximumScore(a, b, c);
        System.out.print(result);
    }
}