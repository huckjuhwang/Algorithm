package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class 단순2진암호코드_1240 {

    public static String cipher[] = {
            "0001101",      // 0
            "0011001",      // 1
            "0010011",      // 2
            "0111101",      // 3
            "0100011",      // 4
            "0110001",      // 5
            "0101111",      // 6
            "0111011",      // 7
            "0110111",      // 8
            "0001011"};     // 9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // setting
        HashMap<String, String> cipher_hash = new LinkedHashMap<>();
        for (int i = 0; i < cipher.length; i++) {
            cipher_hash.put(cipher[i], String.valueOf(i));
        }


        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                // 입력 받은 값이 1이 포함되어 있는지 확인
                if (!str.contains("1") || sum != 0) {
                    continue;
                }

                // 1 위치 파악
                int lastIndex = str.lastIndexOf("1");

                // 총 8개의 암호화 문자
                int idx = 8;
                char arr[] = new char[idx];
                while (idx != 0) {
                    String num = str.substring(lastIndex - 6, lastIndex + 1);
                    arr[--idx] = cipher_hash.get(num).charAt(0);
                    lastIndex = lastIndex - 7;
                }

                if (isValid(new String(arr))) {
                    for (int j = 0; j < arr.length; j++) {
                        sum += arr[j] - '0';
                    }
                    System.out.println("#" + testCase + " " + sum);
                }else{
                    System.out.println("#" + testCase + " 0");
                    sum = -1;
                }
            }
        }
    }

    /**
     * 현재 값이 올바른 검증 코드가 맞는지 판단
     */
    public static boolean isValid(String str) {

        int odd = 0;
        int even = 0;

        for (int i = 0; i < str.length(); i++) {
            // 짝수
            if (i % 2 == 0) {
                even += str.charAt(i) - '0';
            }else { // 홀수
                odd += str.charAt(i) - '0';
            }
        }

        return (((odd) + (even * 3)) % 10 == 0) ? true : false;
    }
}
