// Find First and Last Position of Element in Sorted Array
 
// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (nums[mid]<target){
                start=mid+1;
            }else if (nums[mid]==target){
                end=mid;
            }else{
                end=mid-1;
            }
        }
        int first = start;
        if (start<nums.length&&nums[start]==target){
            start = 0;
            end = nums.length-1;
            while (start<end){
                int mid = start+(end-start+1)/2;
                if (nums[mid]>target){
                    end=mid-1;
                }else if (nums[mid]==target){
                    start=mid;
                }else{
                    start=mid+1;
                }
            }
            return new int[]{first,end};
        }
        return new int[]{-1,-1};
        
        //Brute Force
        // if (nums==null || nums.length==0){
        //    return new int[]{-1,-1}; 
        // }
        // ArrayList<Integer> all = new ArrayList<Integer>();
        // for (int i=0;i<nums.length;i++){
        //     if (nums[i]==target){
        //         all.add(i);
        //     }
        // }
        // if (all.size()==0){
        //     return new int[]{-1,-1};
        // }
        // return new int[]{all.get(0),all.get(all.size()-1)};        
    }
}