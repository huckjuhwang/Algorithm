package 동빈나.DP;

/**
 * DP를 사용한 피보나치 수열
 *
 */
public class 피보나치수열_상향식 {

    static long d[];

    public static void main(String[] args) {
        d = new long[1000];
        long fibo = fibo(50);
        System.out.println(fibo);

    }

    public static long fibo(int x) {
        if( x == 1 || x == 2 ){
            return 1;
        }
        if (d[x] != 0) {
            return d[x];
        }
        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }

}
