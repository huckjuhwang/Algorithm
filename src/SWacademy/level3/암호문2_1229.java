package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 암호문2_1229 {

    public static ArrayList<Integer> number;
    public static Scanner scan;

    public static void main(String[] args) throws IOException {

        scan = new Scanner(System.in);
        int t = 10;

        for (int testCase = 1; testCase <= t; testCase++) {
            // 암호문의 길이
            int N = scan.nextInt();
            number = new ArrayList<>();

            for (int i = 0; i < N; i++)   number.add(scan.nextInt());
            int M = scan.nextInt();
            for (int i = 0; i < M; i++) {
                char ch = scan.next().charAt(0);

                if (ch == 'I') {
                    insert();
                }else if (ch == 'D'){
                    delete();
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + testCase + " ");

            int idx = 0;
            for (Integer num : number) {
                sb.append(num + " ");
                if (++idx == 10)   break;
            }
            System.out.println(sb);
        }
    }

    private static void delete() {
        int idx= scan.nextInt();
        int len = scan.nextInt();

        for (int j = 0; j < len; j++) {
            number.remove(idx);
        }
    }

    private static void insert() {
        int idx= scan.nextInt();
        int len = scan.nextInt();

        for (int j = 0; j < len; j++) {
            number.add(idx++, scan.nextInt());
        }
    }
}
