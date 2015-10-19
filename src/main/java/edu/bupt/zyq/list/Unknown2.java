package edu.bupt.zyq.list;

import java.util.Scanner;

/**
 * Created by zangyq on 2015/9/29.
 */
public class Unknown2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double r = in.nextDouble();
        double maxX = x + r;
        double minX = x - r;
        double maxY = y + r;
        double minY = y - r;
        int rightX = (int) Math.floor(maxX);
        int leftX = (int) Math.floor(minX);
        int upY = (int) Math.floor(maxY);
        int downY = (int) Math.floor(minY);
        double maxDis = 0;
        int maxI = leftX;
        int maxJ = downY;
        for (int i = rightX; i >= leftX; i--) {
            for (int j = upY; j >= downY; j--) {
                if(Math.sqrt((x - i) * (x - i) + (y - j) * (y - j)) <= r){
                    double temp = Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
                    if (temp > maxDis) {
                        maxDis = temp;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        System.out.print(maxI + " " + maxJ);

    }

}
