import java.util.*;
class startInString {
    public static void main(String[] args){
        String s = "leet**cod*e";
        String result = "";
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Deque<Character> deq = new ArrayDeque<>();
        int i;
        for(i = 0; i<n;i++){
            char c = s.charAt(i);
            if(c=='*'&&!deq.isEmpty())
                deq.removeLast();
            else
                deq.addLast(c);
        } 
        if(deq.isEmpty()) System.out.print("");
        while(!deq.isEmpty())
            sb.append(deq.removeFirst());
        System.out.print(sb);
    }
}
