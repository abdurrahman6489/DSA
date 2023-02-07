/*
You are given a string S of length N. Find the character which occurs the most number of times in this string. If there are mutliple such characters present, print -1.
Input
The first line of the input contains a single integer N.
The second line of the input contains a string S.

Constraints:
2 ≤ N ≤ 105
All characters in string S are lowercase english letters.
Output
Print the character which occurs the most number of times in this string. If there are mutliple such characters present, print -1.
Example
Sample Input:
7
abadcar

Sample Output:
a
 */
package Hashmap;
import java.util.*;
public class maximum_frequency_character {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            HashMap<Character, Integer> myMap = new HashMap<>();
            for(int i=0;i<N;i++){
                char c = str.charAt(i);
                    myMap.put(c,myMap.getOrDefault(c,0)+1);
            }
            TreeMap<Integer,ArrayList<Character>> freq = new TreeMap<>(Collections.reverseOrder());
            for(Map.Entry<Character, Integer> entry: myMap.entrySet()){
                char a = entry.getKey();
                int x = entry.getValue();
                if(!freq.containsKey(x)){
                    ArrayList<Character> list = new ArrayList<>();
                    list.add(a);
                    freq.put(x,list);
                }
                else{
                    ArrayList<Character> list1 = freq.get(x);
                    list1.add(a);
                    freq.put(x,list1);
                }
            }
            ArrayList<Character> list3 = freq.get(freq.firstKey());
            if(list3.size()==1)
                System.out.print(list3.get(0));
            
            else
                System.out.print(-1);
        }
    }
}
