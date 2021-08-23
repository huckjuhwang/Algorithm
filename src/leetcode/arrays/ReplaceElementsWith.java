package leetcode.arrays;

/**
 *
 * 2021.08.23
 *
 * Q.Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 *
 * Example 2:
 *
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 *
 *
 * 풀이 방법.
 *
 * 계속해서 max를 구하게 되면 n^2의 성능을 보이기 때문에
 * 한번 MAX를 구하고 그 값이 등장할때까지 해당 배열로 채우다가
 * MAX값이 있는 인덱스로 올 경우 새로운 MAX를 찾도록 함.
 * 
 * 성능, 속도 99퍼
 */
public class ReplaceElementsWith {

    public static void main(String[] args) {
//        int[] arr = replaceElements(new int[]{17,18,5,4,6,1});
        int[] arr = replaceElements(new int[]{1});

        for( int num : arr ){
            System.out.println(num);
        }

    }
    public static int maxEle(int[] arr, int index){
        int max=0;
        for(int i=index; i<arr.length; i++)
            if( max < arr[i] )  max = arr[i];
        return max;
    }

    public static int[] replaceElements(int[] arr) {
        int result[] = new int[arr.length];
        int max = maxEle(arr, 1);
        result[0] = max;

        if( arr.length < 2 ) return new int[]{-1};

        for ( int i = 1; i<arr.length-1; i++ ){
            // index 오른쪽 있는 값 중에 가장 큰값
            if( arr[i] == max )
                max = maxEle(arr, i+1);
             result[i] = max;
        }

        result[arr.length-1] = -1;
        return result;
    }
}
