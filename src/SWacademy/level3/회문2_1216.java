package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문2_1216 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        int size = 100;

        for (int testCase = 1; testCase <= t; testCase++) {

            int count = 0;
            char arr[][] = new char[size][size];
            Integer.parseInt(br.readLine());
            int max = 0;

            /**
             * input
             */
            for (int i = 0; i < size; i++) {
                String nums = br.readLine();
                for (int j = 0; j < size; j++) {
                    arr[i][j] = nums.charAt(j);
                }
            }

            /**
             * 기존 배열에서 90도 회전한 배열 저장
             */
            char[][] rotate = new char[size][size];
            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    rotate[i][j] = arr[size-1-j][i];
                }
            }


            int n = 100;

            /**
             * 핵심 비지니스 로직
             */
            while (n != 0) {
                for (int i = 0; i < size; i++) {
                    String str = new String(arr[i]);
                    String rota = new String(rotate[i]);

                    for (int j = 0; j < size-n+1; j++) {
                        if(isPalindrom(str.substring(j, j+n))){
//                        System.out.println(str.substring(j, j+4));
                           max = str.substring(j, j+n).length();
                           break;
                        }
                        if(isPalindrom(rota.substring(j, j+n))){
//                        System.out.println(rota.substring(j, j+4));
                            max = str.substring(j, j+n).length();
                            break;
                        }
                    }
                    if (max != 0) {
                        break;
                    }
                }
                if (max != 0) {
                    break;
                }
                n--;
            }


            System.out.println("#" + testCase + " " + max);

        }
    }


    public static boolean isPalindrom(String str) {
        if (str.equals(new StringBuilder(str).reverse().toString())) {
            return true;
        }
        return false;
    }
}
