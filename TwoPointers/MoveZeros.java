// Move Zeroes

// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:

// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

class Solution {
    public void moveZeroes(int[] nums) {
        // int j = 0;
        // for (int i=0;i<nums.length;i++){
        //     if (nums[i]!=0){
        //         int tmp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = tmp;
        //         j++;
        //     }
        // }
        int start = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==0&&nums[i+1]!=0){
                int tmp = nums[start];
                nums[start] = nums[i+1];
                nums[i+1] = tmp;
                start++;
            }else if(nums[i]==0&&nums[i+1]==0){
                continue;
            }else{
                start++;
            }
        }
    }
}