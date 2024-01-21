package backjoon.replay;

import java.util.Scanner;

public class Q11659 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int arr[] = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = arr[i-1] + scan.nextInt();
        }


        for(int i=0; i<M; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            System.out.println(arr[end] - arr[start-1]);
        }
    }
}
