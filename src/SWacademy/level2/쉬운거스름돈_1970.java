package SWacademy.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운거스름돈_1970 {
    public static void main(String[] args) throws IOException {

        int money[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int myMoney = Integer.parseInt(br.readLine());

            System.out.println("#"  + testCase);
            for (int i = 0; i < money.length; i++) {
                System.out.print(myMoney / money[i] + " ");
                myMoney = myMoney % money[i];
            }
            System.out.println();
        }

    }
}
