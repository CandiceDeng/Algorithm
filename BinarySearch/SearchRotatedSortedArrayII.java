// Search in Rotated Sorted Array II

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

// You are given a target value to search. If found in the array return true, otherwise return false.

// Example 1:

// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true
// Example 2:

// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false

class Solution {
    public boolean search(int[] nums, int target) {
        // for (int i=0;i<nums.length;i++){
        //     if (nums[i]==target){
        //         return true;
        //     }
        // }
        // return false;
        
        if (nums==null || nums.length==0){
            return false;
        }
        int start=0, end=nums.length-1;
        while (start+1<end){
            int mid=start+(end-start)/2;
            if (nums[mid]==target){
                return true;
            }
            if (nums[start]<nums[mid]){
                if (nums[start]<=target&&target<=nums[mid]){
                    end=mid;
                }else{
                    start=mid;
                }
            }else if (nums[start]>nums[mid]){
                if (nums[mid]<=target&&target<=nums[end]){
                    start=mid;
                }else{
                    end=mid;
                }
            }else{
                start++; //deal with duplicates
            }
        }
        if (nums[start]==target||nums[end]==target){
            return true;
        }
        return false;
    }
}