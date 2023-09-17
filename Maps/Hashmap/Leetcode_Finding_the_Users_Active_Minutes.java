
//1817. Finding the Users Active Minutes
//https://leetcode.com/problems/finding-the-users-active-minutes/
import java.util.*;

class Leetcode_Finding_the_Users_Active_Minutes {
    public static void main(String[] args) {
        int logs[][] = { { 0, 5 }, { 1, 2 }, { 0, 2 }, { 0, 5 }, { 1, 3 } };
        int[] result = findingUsersActiveMinutes(logs, 5);
        for (int a : result)
            System.out.print(a + " ");
    }

    static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int i, key, activeMinutes;
        for (i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int minute = logs[i][1];
            HashSet<Integer> set;
            if (!map.containsKey(id))
                set = new HashSet<>();
            else
                set = map.get(id);
            set.add(minute);
            map.put(id, set);
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            key = entry.getKey();
            activeMinutes = entry.getValue().size();
            if (activeMinutes > 0 && activeMinutes <= k)
                result[activeMinutes - 1] += 1;
        }
        return result;
    }
}