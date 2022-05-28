package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한369게임_1926_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (Import369(i)) {
                String number = String.valueOf(i);
                for (int j = 0; j < number.length(); j++) {
                    if (Import369(number.charAt(j) - '0')) {
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            }else{
                System.out.print(i + " ");
            }
        }
    }

    private static boolean Import369(int i) {
        return String.valueOf(i).contains("3") || String.valueOf(i).contains("6") || String.valueOf(i).contains("9");
    }
}
