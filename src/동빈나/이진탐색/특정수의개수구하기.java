package 동빈나.이진탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
zoho 인터뷰
 */
public class 특정수의개수구하기 {

    static BufferedReader br;
    static int[] arr;      // 리스트
    static int N;
    static int target;   // 목표 값


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        // input
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt( st.nextToken());
        }

        int result = rangeTarget(0, N - 1);
        System.out.println(result == 0 ? -1 : result);
    }

    public static int rangeTarget(int start, int end) {
        int leftIDX = getLeftIndex(start, end);
        int rightIDX = getRightIndex(start, end);

        return rightIDX - leftIDX;
    }

    public static int getLeftIndex(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if( arr[mid] >= target ) end = mid;
            else{
                start = mid+1;
            }
        }
        return end;
    }


    public static int getRightIndex(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if( arr[mid] > target ) end = mid;
            else{
                start = mid+1;
            }
        }
        return end;
    }

}
