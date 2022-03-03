package arrays;


import java.util.ArrayList;

/**
 *
 * 2021.08.22
 * Q. You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1. To accommodate this,
 * nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1 :
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1]
 */

public class mergeSortedArray {

    public static void main(String[] args) {
        // case 1.
//        merge(new int[]{1,2,3,9,0,0}, 4, new int[]{9,9}, 2);

        // case 2.
          merge(new int[]{1}, 1, new int[]{}, 0);
    }

    /**
     * 상위 : 속도 0%, 공간 80%
     * 추가적인 배열 생성 없이 할 수있나?
     *
     * ver2. 배열이 아닌 ArrayList를 사용하여 Merge 구현
     * 상위 : 속도 0%, 공간 60%
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        ArrayList<Integer> mergeArr = new ArrayList<>(m+n);
        int oneIndex = 0;
        int twoIndex = 0;

        while ( m!=0 || n!=0 ){
            if ( n == 0 ){
                mergeArr.add(nums1[oneIndex++]);
                m--;
                continue;
            }
            if( m == 0 ){
                mergeArr.add(nums2[twoIndex++]);
                n--;
                continue;
            }

            if( nums1[oneIndex] <= nums2[twoIndex] ){
                mergeArr.add(nums1[oneIndex++]);
                m--;
            }else {
                mergeArr.add(nums2[twoIndex++]);
                n--;
            }
        }

        for( int i=0; i<nums1.length; i++ ){
            nums1[i] = mergeArr.get(i);
            System.out.println(nums1[i]);
        }
    }

}
