//package edu.bupt.zyq;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zangyq on 2015/9/20.
 */
public class WriteFile {



    public boolean helper(int N){
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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner in = new Scanner(System.in);
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int T = sc.nextInt();
        String[] names = {"Seymour", "Laurence"};
        WriteFile mn = new WriteFile();
        FileWriter  out = new FileWriter(new File("out.out"));


//        FileOutputStream fos=new FileOutputStream("output.out");
//        BufferedWriter bw=new BufferedWriter(fos);
//        bw.write("ÄãºÃ");
        for(int i = 1; i <= T; i++){
            int N = sc.nextInt();
            if(mn.helper(N))
                out.write("Case #" + i + ": " + names[0] + "\n");
//                System.out.printf("Case #" + i + ": " + names[0] + "\n");
            else
            out.write("Case #" + i + ": " + names[1] + "\n");
//                System.out.printf("Case #" + i + ": " + names[1] + "\n");
        }
        out.close();
    }
}
