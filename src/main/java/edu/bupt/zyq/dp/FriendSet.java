package edu.bupt.zyq.dp;

import java.util.*;

/**
 * Created by zangyq on 2015/9/13.
 */
public class FriendSet {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //用set，删除不掉，因为foreach时会修改，所有用List
        List<Set<Integer>> set = new ArrayList<Set<Integer>>();
        int N = in.nextInt();
        while (N-- > 0) {
            int m = in.nextInt(), n = in.nextInt();
            Set<Integer> needDel = null;
            if (set.size() < 1) {
                Set<Integer> firstSet = new HashSet<Integer>();
                firstSet.add(m);
                firstSet.add(n);
                set.add(firstSet);
            } else {
                boolean mFound = false, nFound = false;
                Set<Integer> preFound = null;
                for (Set<Integer> tempSet : set) {
                    if (tempSet.contains(m)) {
                        if (mFound) {
                            tempSet.addAll(preFound);
//                            needDel = preFound;
                            set.remove(preFound);
                            break;
                        }
                        mFound = true;
                        nFound = true;
                        tempSet.add(n);
                        preFound = tempSet;
                    } else {
                        if (tempSet.contains(n)) {
                            if (nFound) {
                                tempSet.addAll(preFound);
//                                needDel = preFound;
                                set.remove(preFound);
                                break;
                            }
                            mFound = true;
                            nFound = true;
                            tempSet.add(n);
                            preFound = tempSet;
                        }
                    }
                }
                if(!mFound && !nFound){
                    Set<Integer> newSet = new HashSet<Integer>(2);
                    newSet.add(m);
                    newSet.add(n);
                    set.add(newSet);
                }
//                if(needDel != null) set.remove(needDel);
            }
        }
        List<Integer> res = new ArrayList<Integer>(set.size());
        for(Set<Integer> temp: set){
            res.add(temp.size());
        }
        Collections.sort(res, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2)return -1;
                if(o1 < o2)return 1;
                return 0;
            }
        });
        System.out.println(res);
    }

}
