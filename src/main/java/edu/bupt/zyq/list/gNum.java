package edu.bupt.zyq.list;//package edu.bupt.zyq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zangyq on 2015/9/20.
 */
public class gNum {



    public boolean helper(long N){
        if( N == 1 || N == 2 || N == 3) return true;
        long n = N;
        boolean Zero = true;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 2; i <= N / 2 && i <= n; i++){
            if(n % i == 0 ){
                int count = 0;
                while(n % i == 0){
                    n = n / i;
                    count ++;
                }
                map.put(i, count);
            }
        }
        int single = 0;
        for(int t: map.keySet()){
            if(map.get(t) == 1) single++;
        }
        if((map.size() - single) % 2 == 1) Zero = false;
        return  (single == 0 || single % 2 == 1)? Zero: !Zero;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        Scanner in = new Scanner(System.in);
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int T = sc.nextInt();
        String[] names = {"Seymour", "Laurence"};
        gNum mn = new gNum();
        for(int i = 1; i <= T; i++){
            long N = sc.nextLong();
            if(mn.helper(N))
                System.out.printf("Case #%d: Seymour\n", i);
            else
                System.out.printf("Case #%d: Laurence\n", i);
        }

    }
}
