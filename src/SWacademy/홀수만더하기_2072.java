package SWacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 홀수만더하기_2072 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int sum =0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            while (st.countTokens() >= 1){
                int num = Integer.parseInt(st.nextToken());
                if ( num % 2 == 1) {
                    sum += num;
                }
            }

            System.out.println("#" + (i+1) + " " + sum);
            sum=0;
        }

    }
}
