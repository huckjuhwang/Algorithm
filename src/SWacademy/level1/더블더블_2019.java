package SWacademy.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더블더블_2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 1;

        System.out.print(sum + " ");
        for (int i = 0; i < n; i++) {
            sum *= 2;
            System.out.print(sum + " ");
        }
    }
}
