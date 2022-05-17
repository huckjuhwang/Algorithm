package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장애물경주난이도_6730 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());


            int asc = 0;
            int desc = 0;

            for (int i = 0; i < n-1; i++) {

                int num = Math.abs(arr[i] - arr[i + 1]);

                if (arr[i] < arr[i + 1] && asc < num)
                    asc = num;


                if (arr[i] > arr[i + 1] && desc < num)
                    desc = num;
            }

            System.out.println("#" + testCase + " " + asc + " " + desc);


        }
    }
}
