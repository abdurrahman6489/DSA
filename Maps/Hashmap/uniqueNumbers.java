import java.util.*;

public class uniqueNumbers {
    static int reverseNumber(int number) {
        int digit = 0;
        int value = 0;
        while (number > 0) {
            digit = number % 10;
            value = value * 10 + digit;
            number /= 10;
        }
        return value;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 13, 10, 12, 31 };
        Set<Integer> uniqueNumberSet = new HashSet<>();
        for (int num : nums) {
            uniqueNumberSet.add(num);
            if (num > 9)
                uniqueNumberSet.add(reverseNumber(num));
        }
        Iterator<Integer> it = uniqueNumberSet.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
