package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(countByRange(arr, x, x)).append(" ");
        }

        System.out.println(sb);
    }

    public static int countByRange(int arr[], int leftVal, int rightVal) {
        int leftIndex = lowerBound(arr, leftVal, 0, arr.length);
        int rightIndex = upperBound(arr, rightVal, 0, arr.length);
        return rightIndex - leftIndex;
    }

    public static int lowerBound(int arr[], int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if( arr[mid] >= target ) end = mid;
            else start = mid+1;
        }
        return end;
    }

    public static int upperBound(int arr[], int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target)  end = mid;
            else start = mid+1;
        }
        return end;
    }



}


