package 동빈나.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 고정점찾기 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(binary_search(arr, 0, n - 1));

    }

    public static int binary_search(int arr[], int start, int end) {

        if( start > end) return -1;
        int mid = 0;
        boolean check = false;

        mid = (start + end) / 2;
        if (mid == arr[mid]) {
            return mid;
        }else if( mid > arr[mid] ){
            return binary_search(arr, mid + 1, end);
        }else{
            return binary_search(arr, start, mid - 1);
        }
    }
}
