
/*Sum as per frequency

Problem Statement
There are N numbers A1, A2,...., An, and you are given Q queries. In each query, you are given two integers l and r.
You are required to print the sum of all the numbers whose frequency of occurrence is between l and r (including l and r). Print a single integer for each query in a new line.
Input
The first line contains N denoting the size of the array.
The second line contains N integers denoting the elements of the array.
The third line contains Q denoting the number of queries.
Next Q lines contain l and r.

Constraints
1 ≤ N ≤ 1000000
1 ≤ Ai ≤ 1000000
1 ≤ Q ≤ 1000000
1 ≤ l ≤ r ≤ N
Output
For each query, print the sum of all elements of the array whose frequency of occurrence is between l and r (inclusive) in a new line.
Example
Sample Input
8
4 4 6 5 3 3 3 9
4
1 4
2 7
3 7
5 6
Sample Output
37
17
9
0 
*/
import java.util.*; // contains Collections framework

class SumFrequency {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            HashMap<Integer, Integer> map = new HashMap<>();
            TreeMap<Integer, Long> countMap = new TreeMap<>();
            ArrayList<Long> resultList = new ArrayList<>();
            resultList.add(0L);
            int n = sc.nextInt();
            int x, i, number, count;
            long sum = 0L;
            int left, right;
            for (i = 0; i < n; i++) {
                x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                number = entry.getKey();
                count = entry.getValue();
                countMap.put(count, countMap.getOrDefault(count, 0L) + (long) number);
            }
            for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
                sum += (long) entry.getValue();
                resultList.add(sum);
            }
            int maxFreq = resultList.size() - 1;
            int queries = sc.nextInt();
            for (i = 0; i < queries; i++) {
                left = sc.nextInt();
                right = sc.nextInt();
                if (left > maxFreq)
                    System.out.println(0);
                else if (left <= 1 && right >= maxFreq)
                    System.out.println(resultList.get(maxFreq));
                else if (right >= maxFreq)
                    System.out.println(resultList.get(maxFreq) - resultList.get(left));
                else
                    System.out.println(resultList.get(right) - resultList.get(left));
            }
        }
    }
}