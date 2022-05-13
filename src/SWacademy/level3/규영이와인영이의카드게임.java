package SWacademy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임 {

    static int A[];
    static int B[];
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            A = new int[9];
            B = new int[9];
            boolean check[] = new boolean[18];

            win = 0;
            lose = 0;
            
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                check[A[i]] = true;
            }

            int idx = 0;
            for (int i = 0; i < check.length; i++) {
                if (!check[i]) {
                    B[idx++] = i;
                }
            }

            permutation(A, 0, 9);

            System.out.println(win);
            System.out.println(lose);
        }
    }
    static void permutation(int[] arr, int depth, int r) {
        if (depth == r) {
            int Asum = 0;
            int Bsum = 0;
            for (int i = 0; i < r; i++) {
                if (arr[i] > B[i]) {
                    Asum += (arr[i] + B[i]);
                } else {
                    Bsum += (arr[i] + B[i]);
                }
            }
            if (Asum > Bsum) {
                win++;
            } else {
                lose++;
            }
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            int temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;

            permutation(arr, depth + 1, r);

            arr[i] = arr[depth];
            arr[depth] = temp;
        }
    }

}
