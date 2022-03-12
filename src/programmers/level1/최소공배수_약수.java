package programmers.level1;

public class 최소공배수_약수 {

    public static void main(String[] args) {
        int[] solution = solution(18, 12);
        for (int i = 0; i < solution.length; i++) {
            System.out.println("solution = " + solution[i]);
        }
    }

    public static int[] solution(int n, int m) {
        int gcd = n>m ? gcd(n, m) : gcd(m, n);
        return new int[]{gcd, n*m/gcd};
    }

    /**
     *  최소 공약수
     */
    public static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n%m);
    }
}
