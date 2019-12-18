// Sort an Array

// Given an array of integers nums, sort the array in ascending order.

// Example 1:

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Example 2:

// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         //Merge from greatest to least to avoid whole nums1 to move backward
//         int i = m-1;
//         int j = n-1;
//         int k = m+n-1;
//         while (k>=0){
//             if (j<0||(i>=0&&nums1[i]>nums2[j])){
//                 nums1[k--] = nums1[i--];
//             }else{
//                 nums1[k--] = nums2[j--];
//             }
//         }
//     }
// }

class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        mergeSort(nums,0,n-1);
        for (int num : nums){
            result.add(num);
        }
        return result;
        
    }
    
    private void mergeSort(int[] nums, int start, int end){
        if (start<end){
            int mid = (start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    
    private void merge(int[] nums, int start, int mid, int end){
        int n1 = mid-start+1;
        int n2 = end-mid;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        for (int i=0; i<n1; ++i){
            left[i] = nums[start+i];
        }
        for (int j=0; j<n2; ++j){
            right[j] = nums[mid+j+1];
        }
        
        int i = 0, j = 0; 
        int k = start; 
        while (i<n1 && j<n2){ 
            if (left[i] <= right[j]){ 
                nums[k] = left[i]; 
                i++; 
            }else{ 
                nums[k] = right[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i<n1){ 
            nums[k] = left[i]; 
            i++; 
            k++; 
        } 
  
        while (j<n2){ 
            nums[k] = right[j]; 
            j++; 
            k++; 
        }         
    }
}