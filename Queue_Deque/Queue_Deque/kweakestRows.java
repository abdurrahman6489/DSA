//1337. The K Weakest Rows in a Matrix
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
import java.util.*;
class kweakestRows{
    public static int[] kWeakestRows(int[][] mat, int k) {
        int resultIndices[] = new int[k];
        int rowsLength = mat.length;
        PriorityQueue<Pair> soldiersQueue = new PriorityQueue<Pair>(11, new SoldierComparator());
        int i;
        for(i=0;i<rowsLength;i++){
            int countOfSoldiers = countSoldiers(mat,i);
            Pair p = new Pair(countOfSoldiers, i);
            soldiersQueue.add(p);
        }
        i = 0;
        while(!soldiersQueue.isEmpty() && k>0){
            Pair p1 = soldiersQueue.poll();
            resultIndices[i++] = p1.getRowIndex();
            k--;
        }
        return resultIndices;
    }
    public static int countSoldiers(int array[][], int rowNo){
        int count = 0;
        for(int i = 0;i<array[0].length;i++){
            if(array[rowNo][i]==0)
                return count;
            else
                count++;
        }
        return count;
    }
    public static void main(String[] args){
        int matrix[][] = {{1,1,0,0,0},
                         {1,1,1,1,0},
                         {1,0,0,0,0},
                         {1,1,0,0,0},
                         {1,1,1,1,1}};
        int k = 3;
        int result[] = kWeakestRows(matrix, k);
        for(int j = 0;j<result.length;j++)
            System.out.print(result[j]+" ");
    }
}
class SoldierComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if(p1.soldiers>p2.soldiers)
            return 1;
        if(p1.soldiers<p2.soldiers)
            return -1;
        if(p1.soldiers==p2.soldiers){
            if(p1.rowIndex>p2.rowIndex)
                return 1;
            else if(p1.rowIndex<p2.rowIndex)
                return -1;
        }
        return 0;
    }
}
class Pair{
    int soldiers;
    int rowIndex;
    Pair(int soldiers, int rowIndex){
        this.soldiers = soldiers;
        this.rowIndex = rowIndex;
    }
    public int getSoldiers(){
        return soldiers;
    }
    public int getRowIndex(){
        return rowIndex;
    }
}