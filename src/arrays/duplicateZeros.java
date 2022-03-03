package arrays;

import java.util.ArrayList;

/**
 *
 * 2021.08.22
 *
 * Q. Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications
 * to the input array in place and do not return anything.
 *
 * Exam 1.
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 */
public class duplicateZeros {


    public static void main(String[] args) {
        duplicateZeros.duplicateZeros(new int[]{1,0,2,0,4,5});
    }

    /**
     * 상위 속도 : 63%
     * @param arr
     */
    public static void duplicateZeros(int[] arr) {
        ArrayList<Integer> arrL = new ArrayList<>(arr.length*2);
        for ( int num : arr ){
            if( num == 0 ){
                arrL.add(num);
                arrL.add(num);
            }else {
                arrL.add(num);
            }

            if( arrL.size() == arr.length ){
                break;
            }
        }
        for( int i=0; i<arr.length; i++ ){
            arr[i] = arrL.get(i);
        }
    }

}
