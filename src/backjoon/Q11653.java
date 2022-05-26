package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> factorization = getFactorization(n);
        for (int num : factorization) {
            System.out.println(num);
        }
    }
    public static List<Integer> getFactorization(int n) {
        List<Integer> result = new ArrayList<>();
        int idx = 2;
        while (n > 1) {
            while (n % idx == 0) {
                n /= idx;
                result.add(idx);
            }
            idx++;
        }

        if (n != 1) {
            result.add(n);
        }
        return result;
    }
}
