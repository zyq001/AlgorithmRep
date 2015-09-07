package edu.bupt.zyq.list;

/**
 * Created by zangyq on 2015/9/7.
 */
public class HIndexII {
    /**
     * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
     * */

    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1) return 0;
        int length = citations.length, left = 0, right = length - 1, mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(citations[mid] == length - mid)       return length - mid;
            else if (citations[mid] > length - mid) right = mid - 1;
            else  left = mid + 1;
        }
        return length - (right + 1);//不是0，是上一次比较后的右指针还有往右一个位置。
    }

    public static void main(String[] args){
        int[] test = {1,2,3, 5, 12,13};
        System.out.println(new HIndexII().hIndex(test));
    }
}
