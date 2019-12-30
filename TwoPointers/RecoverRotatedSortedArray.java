// Recover Rotated Sorted Array

// Given a rotated sorted array, recover it to sorted array in-place.（Ascending）

// Example
// Example1:
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
// Example2:
// [6,8,9,1,2] -> [1,2,6,8,9]

// Challenge
// In-place, O(1) extra space and O(n) time.

// Clarification
// What is rotated array?

// For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        //3-step reverse
        int n = nums.size()-1;
        for (int i=0;i<n;i++){
            //#1 Find Peak
            if (nums.get(i)>nums.get(i+1)){
                //#2 Reverse seperately
                reverseArray(nums,0,i);
                reverseArray(nums,i+1,n);
                //#3 Reverse array
                reverseArray(nums,0,n);
            }
        }
    }
    public void reverseArray(List<Integer> nums, int start, int end){
        while (start<end){
            int tmp = nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end,tmp);
            start++;
            end--;
        }
    }
}