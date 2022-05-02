package 동빈나.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진탐색 {

    static int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int result = binary_search(7, 0, arr.length - 1);
        if (result == -1) {
            System.out.println("data not found!");
        }else {
            System.out.println(result);
        }


    }

    public static int binary_search(int target, int start, int end) {
        // 값이 없을 경우
        if (start > end) return -1;
        int mid = (start+end)/2;

        if (arr[mid] == target) {
            return mid+1;
        }else if( arr[mid] > target ){
            return binary_search(target, start, mid - 1);
        }else {
            return binary_search(target, mid + 1, end);
        }
    }
}
