// Kth Largest Element in an Array

// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:

// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
// Example 2:

// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4
// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        return quickSelect(nums,k-1,0,nums.length-1);
    }
    private int quickSelect(int[] nums,int k,int start,int end){
        int mid = (start+end)/2;
        int pivot = nums[mid];
        int left = start, right = end;
        while (start<=end){
            while (nums[start]>pivot){
                start++;
            }
            while (left<right&&nums[end]<pivot){
                end--;
            }
            if (start<=end){
               swap(nums,start,end);
                start++;
                end--;
            }
            //Now end points to one number before start     
        }
        //If end is still greater than k, then k appears at the left side of pivot
        if (left<end&&k<=end){
            return quickSelect(nums,k,left,end);
        }
        //If end is less than k, then k appears at the right side of pivot
        if (start<right&&k>=end){
            return quickSelect(nums,k,start,right);
        }
        return nums[k];
        
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}