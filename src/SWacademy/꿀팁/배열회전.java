package SWacademy.꿀팁;

import java.util.*;

public class 배열회전 {

    /**
     * end는 n-1로 넘겨줘야함
     */
    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }




    public static void main(String[] args) {


        /**
         *  배열 90도 회전
         */
//        char[][] rotate = new char[size][size];
//
//        for (int i = 0; i < rotate.length; i++) {
//            for (int j = 0; j < rotate[i].length; j++) {
//                rotate[i][j] = arr[size-1-j][i];
//            }
//        }

        /**
         * char 배열 String으로 변환
         */
//        new String(arr)

        /**
         * hashSet -> ArrayList로 변환
         */
//        public static Set<Integer> rank5
//        rank5 = new HashSet<>();
//        List rank5List = new ArrayList(rank5);
//        Collections.sort(rank5List, Collections.reverseOrder());



//        @Override
//        public int compareTo(Node other) {
//            if (this.getFail() == other.getFail()) {
//                // 오름차순
//                return Integer.compare(this.getStage(), other.getStage());
//            }
//            // 내림차순
//            return Double.compare(other.getFail(), this.getFail());
//        }
    }
}
