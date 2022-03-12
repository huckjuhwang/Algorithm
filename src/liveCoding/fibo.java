package liveCoding;

public class fibo {

    static long d[];

    /**
     * bottom up
     */

    public static void main(String[] args) {

        d = new long[100];
        d[1] = 1;
        d[2] = 1;

        int n = 50;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println("d[n] = " + d[n]);
//        d[n] = 12586269025

//        long fibo = fibo(50);
//        System.out.println("fibo = " + fibo);

    }

    /**
     * top down
     */
    public static long fibo(int x){

        if (x == 1 || x == 2) {
            return 1;
        }

        if (d[x] != 0) {
            return d[x];
        }

        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }
}
