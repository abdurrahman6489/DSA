//1817. Finding the Users Active Minutes
//https://leetcode.com/problems/finding-the-users-active-minutes/
import java.util.*;
class Leetcode_Finding_the_Users_Active_Minutes {
    public static void main(String[] args){
        int logs[][] = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        findingUsersActiveMinutes(logs, 4);
    }
    static void findingUsersActiveMinutes(int[][] logs, int k) {
        int res[] = new int[k];
        int n = logs.length; int key; int val;
        HashMap<Integer,Set<Integer>> freq = new HashMap<>();
        TreeMap<Integer,Integer> uam = new TreeMap<>();
        int i; int idx; int times;
        for(i=0;i<n;i++){
            idx = logs[i][0];
            times = logs[i][1];
            freq.putIfAbsent(idx,new HashSet<>());
            freq.get(idx).add(times);
        }
        //System.out.println("The set is");
        
        
        // System.out.println("The freq map is");
        // System.out.println(freq);
        for(Map.Entry<Integer,Set<Integer>> entry : freq.entrySet()){
           val = entry.getValue().size();
            uam.put(val,uam.getOrDefault(val,0)+1);
        }
        System.out.println("The uam treemap is");
        System.out.println(uam);
        for(Map.Entry<Integer,Integer> entry : uam.entrySet()){
            key = entry.getKey();
            val = entry.getValue();
            res[key-1] = val;
            System.out.println(res[key-1]);
        }
        for(i=0;i<k;i++){
            System.out.println(res[i]);
        }
        return;
    }
}