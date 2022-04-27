package SWacademy.level3;

import java.util.ArrayList;
import java.util.List;

public class 백만이하의모든소수_3131 {
    public static void main(String[] args) {

        int n = 1000000;
        List<Integer> prime = getPrime(n);
        for (int i = 0; i < prime.size(); i++) {
            System.out.print(prime.get(i) + " ");
        }
    }

    private static List<Integer> getPrime(int n) {

        List<Integer> prime = new ArrayList<>();

        boolean primeCheck[] = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            // 한번도 등장하지 않았다면,
            if (!primeCheck[i]) {
                // 소수 추가
                prime.add(i);

                // 이후, 배수의 결과를 제외 시켜준다.
                for (int j = i + i; j <= n; j += i) {
                    primeCheck[j] = true;
                }
            }
        }
        return prime;
    }
}
