package edu.bupt.zyq.list;

/**
 * Created by root on 15-9-19.
 */
public class PrintMatrix {
    public int[] arrayPrint(int arr[][], int n) {

        // length
        int len = arr.length;
        // new result
        int result[] = new int[len * len];

        int cnt = 0;

            for (int j =len-1;j>=0;j--) {
                result[cnt] = arr[0][j];
                cnt = cnt+1;
                int t = 1;
                int w = j+1;
                while (t <len && w <len) {
                    result[cnt] = arr[t][w];
                    t++;
                    w++;
                    cnt =cnt+1;
                }
            }

            for (int i = 1; i < len;i++) {
                result[cnt] = arr[i][0];
                cnt = cnt+1;
                int t =i+1;
                int w=1;
                while (t <len && w <len) {
                    result[cnt] = arr[t][w];
                    cnt = cnt+1;
                    t++;
                    w++;
                }
            }

        return result;
    }
    public  static void main(String[] args) {
        Solution s = new Solution();
        int[][]a = {{1,2,3},{5,6,7},{8,9,10}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        int[] re = s.arrayPrint(a, 3);
        for (int i = 0; i < re.length; i++) {
            System.out.print(re[i] + " ");
        }

        //System.out.println("a");
    }
}

