package book;

import java.util.Arrays;

public class book5_4 {

    public static void main(String[] args) {

    }


    public int[] solution(int[] arr) {
        /**
         * 만약 원본 배열을 가만히 두고 싶다면
         */
        int[] clone = arr.clone();
        Arrays.sort(clone);

        Arrays.sort(arr);
        return arr;

    }
}
