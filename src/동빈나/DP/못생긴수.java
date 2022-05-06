package 동빈나.DP;

import java.util.Scanner;

public class 못생긴수 {


    static int numbers[] = {2, 3, 4, 5};
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d[] = new int[1000];

        d[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        int next2 = 2;
        int next3 = 3;
        int next5 = 5;

        for (int i = 1; i < n; i++) {
            d[i] = Math.min(next2, Math.min(next3, next5));

            if (d[i] == next2) {
                i2 = i2 + 1;
                next2 = d[i2] * 2;
            }
            if (d[i] == next3) {
                i3 = i3 + 1;
                next3 = d[i3] * 3;
            }
            if (d[i] == next5) {
                i5 = i5 + 1;
                next5 = d[i5] * 5;
            }
        }
        System.out.println(d[n - 1]);
    }
}
