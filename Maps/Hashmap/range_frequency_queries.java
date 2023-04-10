
import java.util.*;
public class range_frequency_queries {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the array elements");
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            RangeFreqQuery object = new RangeFreqQuery(arr);
            System.out.print("enter left range, right range and the value for its frequency");
            int left = sc.nextInt();
            int right = sc.nextInt();
            int val = sc.nextInt();
            int result = object.query(left,right,val);
            System.out.println(result);

        }


    }
}
class RangeFreqQuery {
    HashMap<Integer,TreeMap<Integer,Integer>> map = null;
    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        int i; int x;
        map = new HashMap<>();

        //storing the numbers as keys of hashmap and in values using treemap which stores indices of elements in keys and prefix freq in its values
        for(i=0;i<n;i++){
            x = arr[i];
            if(!map.containsKey(x)){
                TreeMap<Integer,Integer> index = new TreeMap<>();
                index.put(i,1);
                map.put(x,index);
            }
            else{
                TreeMap<Integer,Integer> tr = map.get(x);
                int index = tr.lastKey();
                int val = tr.get(index);
                tr.put(i,val+1);
            }
        }
    }
    
    //for query it will not take each time O(N), using treeMap it takes O(log n)
    public int query(int left, int right, int value) {
        if(map.containsKey(value)){
            TreeMap<Integer,Integer> result = map.get(value);
            int left_range = -1;
            if(right<result.firstKey()||left>result.lastKey()) return 0;
            if(left<=result.firstKey()){
                int right_range = result.floorKey(right);
                return result.get(right_range);
            }
            else
                left_range = result.floorKey(left-1);
            
            int right_range = result.floorKey(right);
            return result.get(right_range) - result.get(left_range);
        }
        return 0;
    }
}
