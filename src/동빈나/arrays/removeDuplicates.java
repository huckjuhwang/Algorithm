package 동빈나.arrays;

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if( nums.length == 0) return 0;
        int temp = nums[0];
        int numsPoint = 1;

        for( int i = 1; i<nums.length; i++){
            if( nums[i] != temp ){
                temp = nums[i];
                nums[numsPoint++] = nums[i];
            }
        }
        return numsPoint;
    }
}
