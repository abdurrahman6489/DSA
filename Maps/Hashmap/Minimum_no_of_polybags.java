
import java.util.*;
class Minimum_no_of_polybags{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the total number of polybags");
            int n = sc.nextInt();
            System.out.println("Enter the total weight to be carried");
            long total_weight = sc.nextLong();
            long size_Of_CurPolybag = 0;
            long no_Of_CurPolybag_Present = 0;
            long count_Of_curSizePolybag_Used = 0;
            long total_Polybags_Used = 0;
            System.out.println("Enter the capacity of each Polybag present");
            TreeMap<Long,Long> freq = new TreeMap<>(Collections.reverseOrder());
            for(int i=0;i<n;i++){
                Long x = sc.nextLong();
                freq.put(x,freq.getOrDefault(x,0L)+1);
            }
            for(Map.Entry<Long,Long> entry: freq.entrySet()){
                size_Of_CurPolybag = entry.getKey();
                no_Of_CurPolybag_Present = entry.getValue();
                if(size_Of_CurPolybag>=total_weight){
                    count_Of_curSizePolybag_Used = 1;
                }
                else if(size_Of_CurPolybag*no_Of_CurPolybag_Present>=total_weight){
                    count_Of_curSizePolybag_Used = total_weight/size_Of_CurPolybag;
                    if(total_weight%size_Of_CurPolybag!=0){
                        count_Of_curSizePolybag_Used++;
                    }
                }
                else{
                    count_Of_curSizePolybag_Used = no_Of_CurPolybag_Present;
                }
                total_Polybags_Used+=count_Of_curSizePolybag_Used;
                total_weight-=count_Of_curSizePolybag_Used*size_Of_CurPolybag;
                if(total_weight<=0){
                    System.out.println("Total number of polybags used is");
                    System.out.println(total_Polybags_Used);
                    break;
                }

            }
            if(total_weight>0){
                System.out.println("Total weight cannot be carried even after using all the polybags used");
            }
        }
    }
}