package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자조작_13428 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            char ch[] = br.readLine().toCharArray();
            int len = ch.length;

            int arr[][] = new int[len][len];
            int max = Integer.parseInt(new String(ch));
            int min = Integer.parseInt(new String(ch));

            for (int i = 0; i < len-1; i++) {
                for (int j = i+1; j < len; j++) {

                    char temp = ch[j];
                    ch[j] = ch[i];
                    ch[i] = temp;

                    String chgStr = new String(ch);
                    int num = Integer.parseInt(chgStr);
                    arr[i][j] = num;
                    if (num > max && chgStr.charAt(0) != '0') {
                        max = num;
                    }
                    if (num < min  && chgStr.charAt(0) != '0') {
                        min = num;
                    }

                    temp = ch[j];
                    ch[j] = ch[i];
                    ch[i] = temp;

                }
            }

            System.out.println("#" + testCase + " " + min + " " + max);
        }
    }
}
