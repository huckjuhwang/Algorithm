package SWacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백만장자프로젝트_1859 {


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum =0;

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");

            for (int j = 0; j < str.length; j++) {
                sum += Integer.parseInt(str[j]);
            }

            System.out.println("#" + (i+1) + " " + Math.round((double) sum/str.length));
            sum = 0;
        }

    }
}
