//1352. Product of the Last K Numbers
//https://leetcode.com/problems/product-of-the-last-k-numbers/description/
package Queue_Deque;
import java.util.*;
public class Product_of_the_last_k_numbers {
    public static void main(String[] args){
        ProductOfNumbers obj = new ProductOfNumbers();
        obj.add(3);
        obj.add(0);
        obj.add(2);
        obj.add(5);
        obj.add(4);
        System.out.println(obj.getProduct(2));
        System.out.println(obj.getProduct(3));
        System.out.println(obj.getProduct(4));
        obj.add(8);
        System.out.println(obj.getProduct(2));

    }
}
class ProductOfNumbers {
    ArrayList<Integer> stream;
    public ProductOfNumbers() {
        stream = new ArrayList<>();
    }
    
    public void add(int num) {
            if(num!=0&&stream.size()>0){
                int x = stream.get(stream.size() - 1);
                stream.add(x*num);
            }
            else if(num!=0){
                stream.add(num);
            }
            else{
                stream.clear();
            }
    }
    
    public int getProduct(int k) {
        int x,y;
        if(k>stream.size()) 
            return 0;
        else if(k==stream.size())
            return stream.get(stream.size() - 1);
        else{
            x = stream.get(stream.size() - 1);
            y = stream.get(stream.size() - 1 - k);
            return x/y;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */