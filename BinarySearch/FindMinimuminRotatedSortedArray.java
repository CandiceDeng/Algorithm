// Find Minimum in Rotated Sorted Array

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// Example 1:

// Input: [3,4,5,1,2] 
// Output: 1
// Example 2:

// Input: [4,5,6,7,0,1,2]
// Output: 0

class Solution {
    public int findMin(int[] nums) {
        // int minimum=Integer.MAX_VALUE;
        // for (int i=0;i<nums.length;i++){
        //     if (minimum>nums[i]){
        //         minimum=nums[i];
        //     }
        // }
        // return minimum;
        int start=0, end=nums.length-1;
        while (start+1<end){
            // while(nums[start+1]==nums[start]){
            //     start++;
            // } //deal with duplicates
            int mid=start+(end-start)/2;
            if (nums[mid]>nums[start]&&nums[mid]>nums[end]){
                start=mid;
            }else{
                end=mid;
            }
        }
        return nums[start]<=nums[end] ? nums[start] : nums[end];
        
    }
}