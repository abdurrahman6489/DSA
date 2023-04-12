 class stepNumberTo1 {
    static int steps1(int n){// normal recursion
        if(n==1) return 0;
        int ans = 1 + steps1(n-1);
        if(n%2 == 0) ans = Math.min(ans, 1 + steps1(n/2));
        if(n%3 == 0) ans = Math.min(ans, 1 + steps1(n/3));
        return ans;
    }
    static int steps2(int n, int array[]){// recursion + dynamic Programming
        if(n==1) return 0;
        if (array[n]>0) return array[n];
        int ans = 1 + steps2(n-1, array);
        if(n%2 == 0) ans = Math.min(ans, 1 + steps2(n/2, array));
        if(n%3 == 0) ans = Math.min(ans, 1 + steps2(n/3, array));
        array[n] = ans;
        return ans;
    }
    static int steps3(int n){//only dynamic programming no recursion, by loop only
        int array[] = new int[n+1];
        array[1] = 0;
        for(int i = 2; i<=n; i++){
            int ans = 1 + array[i - 1];
            if(i%2==0) ans = Math.min(ans, 1 + array[i/2]);
            if(i%3==0) ans = Math.min(ans, 1 + array[i/3]);
            array[i] = ans;
        }
        return array[n];
    }
    public static void main(String[] args) {
        int n = 1000;
        int array[] = new int[n + 1];
        int result = steps1(n);
        int result1 = steps2(n,array);
        int result2 = steps3(n);
        System.out.println("from step3 "+result2);
        System.out.println("from step2 "+result1);
        System.out.println("from step1 "+result);
    }
}
 