package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2669 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[][] = new int[4][4];
        int valid[][] = new int[101][101];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                if( j <= 1){
                    arr[i][j] = Integer.parseInt(st.nextToken())+1;
                }else{
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i][0]; j <= arr[i][2]; j++) {
                for (int k = arr[i][1]; k <= arr[i][3]; k++) {
                    valid[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                sum += valid[i][j];
            }
        }
        System.out.println(sum);
    }
}
