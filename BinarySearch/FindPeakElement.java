// Find Peak Element

// A peak element is an element that is greater than its neighbors.

// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that nums[-1] = nums[n] = -∞.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 1 or 5 
// Explanation: Your function can return either index number 1 where the peak element is 2, 
//              or index number 5 where the peak element is 6.

class Solution {
    public int findPeakElement(int[] nums) {
        //Brute Force (O(n))
        // int peak = Integer.MIN_VALUE;
        // int index = 0;
        // for (int i=0;i<nums.length;i++){
        //     if (nums[i]>=peak){
        //         peak = nums[i];
        //         index = i;
        //     }
        // }
        // return index;
        
        //Binary Search (O(logn))
        int start=0, end=nums.length-1;
        while (start+1<end){
            int mid = start+(end-start)/2;
            if (nums[mid-1]<nums[mid]&&nums[mid+1]<mid){
                return mid;
            }else if(nums[mid+1]<nums[mid]){
                end=mid;
            }else if(nums[mid]>nums[mid-1]){
                start=mid;
            }else{
                start=mid;
            }
        }
        if (nums[start]>nums[end]){
            return start;
        }else{
            return end;
        }
    }
}