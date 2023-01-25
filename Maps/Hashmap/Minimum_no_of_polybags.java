package Hashmap;
import java.util.*;
class Minimum_no_of_polybags{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array");
            int n = sc.nextInt();
            long total_weight = sc.nextInt();
            int result = 0;
            long sum = 0;
            int arr[] = new int[n];
            System.out.println("Enter the array elements");
            TreeMap<Integer,Integer> freq = new TreeMap<>(Collections.reverseOrder());
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
            }
            for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
                sum+=entry.getKey()*entry.getValue();
                result+=entry.getValue();
                if(sum>=total_weight){
                    System.out.println("Minimum no. of polybags "+result);
                    break;
                }
            }
            
            

        }
    }
}