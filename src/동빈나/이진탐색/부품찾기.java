package 동빈나.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {
/*
5
8 3 7 9 2
3
5 7 9
*/
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int all_comp[] = new int[n];
        for (int i = 0; i < n; i++) {
            all_comp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(all_comp);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            boolean check = binary_search(all_comp, 0, n, Integer.parseInt(st.nextToken()));

            if (check) {
                System.out.print("yes ");
            }else{
                System.out.print("no " );
            }
        }

    }

    public static boolean binary_search(int arr[], int start, int end, int value) {
        if( start >= end ) return false;

        int mid = (start+end)/2;
        if (arr[mid] == value) {
            return true;
        } else if (arr[mid] < value) {
            return binary_search(arr, mid + 1, end, value);
        }else{
            return binary_search(arr, start, mid - 1, value);
        }
    }
}
