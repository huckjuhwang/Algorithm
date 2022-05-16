package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 의석이의세로로말해요_5356 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            char arr[][] = new char[5][15];

            for (int i = 0; i < 5; i++) {
                String str = br.readLine();

                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            System.out.print("#" + testCase + " ");
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[j][i] != '\u0000') {
                        System.out.print(arr[j][i]);
                    }
                }
            }
            System.out.println();
        }

    }
}
