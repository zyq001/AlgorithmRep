package edu.bupt.zyq.list;

/**
 * Created by zangyq on 2015/10/5.
 */
public class Arithmetic {

    public int solution(int[] A, int N){
        if(A == null || N < 3) return -1;
        int re = 0, arithCount = 1, carry = A[0];
        for(int i = 1; i < N; i++){
            int cha = A[i] - A[i - 1];
            if(cha != carry){
                carry = cha;
                re += count(arithCount);
                if(re > 1000000000) return -1;
                arithCount = 2;
            }else{
                arithCount++;
            }
        }
        re += count(arithCount);
        return re;
    }

    public int count(int c){
        if( c < 3) return 0;
        int tmp = c - 2;
        //计算并返回tmp的阶乘
        return tmp * (1 + tmp) / 2;
    }

    public static void main(String[] args){
        int[] rest = {-1, 1, 3, 3, 3,2, 1, 0};
        System.out.println(new Arithmetic().solution(rest, 8));
    }
}
