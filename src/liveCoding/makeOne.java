package liveCoding;

import java.util.Scanner;

public class makeOne {

    public static int d[] = new int[30001];
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1;

            if (i % 2 == 0) {
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }

            if (i % 3 == 0) {
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }

            if (i % 4 == 0) {
                d[i] = Math.min(d[i / 5] + 1, d[i]);
            }
        }
        System.out.println("d[n] = " + d[n]);
    }
}
