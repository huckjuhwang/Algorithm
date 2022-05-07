package 동빈나.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 2021.08.22
 * Q.Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 *
 * Example 2:
 *
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 *
 * Example 3:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class checkIfNAndItsDoubleExist {

    public static void main(String[] args) {
//        System.out.println( checkIfExist(new int[]{-2,0,10,-19,4,6,-8}) );
        System.out.println( checkIfExist(new int[]{0,0}) );
    }

    public static boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> hashmap = new HashMap<>(arr.length);

        for( int i=0; i<arr.length; i++ ){
            if ( arr[i] % 2 == 0)
                hashmap.put(arr[i], hashmap.get(arr[i])!=null ? hashmap.get(arr[i]) + 1 : 1);
        }

        for( int num : arr ){
            // 0은 *2 해도 0이기 때문에 추가적인 조건 지정
            if( num == 0 && hashmap.get(0) == 1) continue;
            // 값이 있는 경우
            if ( hashmap.get(num*2) != null) return true;
        }
        return false;
    }
}
