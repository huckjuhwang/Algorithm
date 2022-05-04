package 동빈나.DP;

/**
 * DP를 사용한 피보나치 수열
 *
 */
public class 피보나치수열_하향식 {

    static long d[];

    public static void main(String[] args) {
        d = new long[1000];
        d[1] = 1;
        d[2] = 1;
        int n = 50;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}
