//921. Minimum Add to Make Parentheses Valid
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
package Stack;
import java.util.*;
class Minimum_Add_to_make_paranthesis_valid{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the string");
            String s = sc.next();
            Stack<Character> st = new Stack<>();
            int i; int n = s.length(); char d = '#';
            int minimum_add = 0;
            for(i=0;i<n;i++){
                char c = s.charAt(i);
                if(c=='('){
                    st.push(c);
                }
                else if(st.isEmpty()){
                    minimum_add++;
                }
                else if(!st.isEmpty() && c == ')'){
                    d = st.pop();
                    if(d!='('){
                        minimum_add++;
                    }

                }
            }
            System.out.println(minimum_add + st.size());
        }
    }
}

