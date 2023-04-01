import java.util.*;
class collectGarbage {
    public static void main(String[] args) {
        String garbage[] ={"G","P","GP","GG"};
        int travel[] = {2,4,3};
        int glassGarbage = 0;
        int paperGarbage = 0;
        int metalGarbage = 0;
        int glasslastHouse = -1;
        int paperlastHouse = -1;
        int metallastHouse = -1;
        int totalTime = 0;
        int n = travel.length;
        int sum = 0; int i;
        for(i = 1;i<n;i++)   travel[i]+=travel[i-1];
        for(i=0;i<=n;i++){
            String s = garbage[i];
            if(s.indexOf("G")>-1) glasslastHouse = i;
            if(s.indexOf("P")>-1) paperlastHouse = i;
            if(s.indexOf("M")>-1) metallastHouse = i;
            for(int j = 0;j<s.length();j++){
                if(s.charAt(j)=='G') glassGarbage++;
                if(s.charAt(j)=='P') paperGarbage++;
                if(s.charAt(j)=='M') metalGarbage++;
            }
        }
        totalTime = glassGarbage + paperGarbage + metalGarbage;
        if(glasslastHouse>0) totalTime+= travel[glasslastHouse-1];
        if(paperlastHouse>0) totalTime+= travel[paperlastHouse-1];
        if(metallastHouse>0) totalTime+= travel[metallastHouse-1];
        System.out.print(totalTime);
    }
}
