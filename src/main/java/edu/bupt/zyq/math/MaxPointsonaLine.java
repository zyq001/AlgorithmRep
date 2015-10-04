package edu.bupt.zyq.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Created by root on 15-10-4.
 */
public class MaxPointsonaLine {

    public int maxPoints(Point[] points) {
        if(points == null) return -1;
        int length = points.length;
        if(length < 3) return length;
        int maxCount = 2;
        Map<Double, Set<Point>> map = new HashMap<Double, Set<Point>>();
        for(int i = 0; i < length; i++){
            int equalCount = 0, tempMax = 1;
            for(int j = i + 1; j < length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    equalCount++;
                    continue;
                }
                double slope = getSlope(points[i], points[j]);
                if(map.containsKey(slope)){
                    Set<Point> ps = map.get(slope);
                    if(!ps.contains(points[j])){
                        ps.add(points[j]);
                    }
                    map.put(slope, ps);
                    tempMax = Math.max(tempMax, ps.size());
                }
                else {
                    Set<Point> set = new HashSet<Point>();
                    set.add(points[i]);
                    set.add(points[j]);
                    map.put(slope, set);
                    tempMax = Math.max(2, tempMax);
                }
            }
            maxCount = Math.max(maxCount, tempMax + equalCount);
        }
        return maxCount;
    }

    public double getSlope(Point p1, Point p2){
        if(p1.x == p2.x) return Double.MAX_VALUE;
        if(p1.y == p2.y) return 0.0;
        return (p1.y - p2.y) / (0.0 + p1.x - p2.x);
    }

    public static void main(String[] args){
        Point[] points = {new Point(3, 10), new Point(0, 2), new Point(0, 2), new Point(3, 10)};
        System.out.println(new MaxPointsonaLine().maxPoints(points));
//        System.out.println(-0.0 == 0.0);
    }
}
