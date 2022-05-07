package 동빈나.arrays;


/**
 *
 * 2021.08.25
 *
 * Q. Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */
public class moveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
//        moveZeroes(new int[]{0,1});
    }

    public static void moveZeroes(int[] nums) {
        int pos = 0;
        int zeroPoint = nums.length;
        for( int num : nums ){
            if( num != 0 )
                nums[pos++] = num;
        }
        while( pos < zeroPoint){
            nums[--zeroPoint] = 0;
        }
    }
}
