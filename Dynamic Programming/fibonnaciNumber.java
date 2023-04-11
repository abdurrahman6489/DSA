
import java.util.*;
class fibonnaciNumber {
    static int findfibonacci(int n, int[] array){
        if(n==0 || n == 1) return 1;
        if(array[n]>0) return array[n];
        int output = findfibonacci(n-1, array) + findfibonacci(n-2, array);
        array[n] = output;
        return output; 
    }
    public static void main(String[] args){
        int n = 20;
        int array[] = new int[n+1];
        int i; array[0] = 1; array[1] = 1;
        for(i=2;i<=n;i++) array[i] = array[i-1] + array[i - 2];
        System.out.println("from iterating "+array[n]);
        Arrays.fill(array,0);
        int result = findfibonacci(n,array);
        System.out.println("from recursion function "+result);
    }
}
