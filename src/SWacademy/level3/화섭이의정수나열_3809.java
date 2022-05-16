package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 화섭이의정수나열_3809 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = scan.nextInt();


        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scan.nextInt();
            String str = "";

            for (int i = 0; i < n; i++) {
                str += scan.nextInt()+"";
            }

            for(int i =0; ; i++){
                if (!str.contains(i +"")) {
                    System.out.println("#" + testCase + " " + i);
                    break;
                }
            }
        }
    }
}
