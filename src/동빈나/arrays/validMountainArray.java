package 동빈나.arrays;

/**
 *
 * 2021.08.22
 * Q. Given an array of integers arr, return true if and only if it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 *
 * Example 1:
 *
 * Input: arr = [2,1]
 * Output: false
 *
 * Example 2:
 *
 * Input: arr = [3,5,5]
 * Output: false
 *
 * Example 3:
 *
 * Input: arr = [0,3,2,1]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */
public class validMountainArray {

    public static void main(String[] args) {
        System.out.println(validMountainArray.validMountainArray( new int[]{1,2,3,5,7,9,10,12,14,15,16,18,14,13,15} ));
    }
    public static boolean validMountainArray(int[] arr) {
        boolean mount = true;
        int max = -1;
        // 꼭대기 찾는 과정
        for ( int i =0; i<arr.length; i++)
            if( arr[i] > max ) max = arr[i];

        // 오르막길 밖에 없는 경우 && 내리막길 밖에 없는 경우 && 하나만 있는 경우 && 처음에 내려가는 경우 처리
        if( max == arr[arr.length-1] ||  max == arr[0] || arr[0] > arr[1]) return false;

        for( int i =1; i<arr.length -1 ; i++ ){
            // 정상이면 false 로
            if( max == arr[i]) mount = false;
            // 올라가는 중인데 내려갈 경우 false
            if( mount && arr[i] >= arr[i+1] ) return false;
            // 내려가는 중인데 올라갈 경우 false
            if( !mount && arr[i] <= arr[i+1] ) return false;
        }
        return true;
    }
}
