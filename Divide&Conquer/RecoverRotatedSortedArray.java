// Recover Rotated Sorted Array

// Example1:
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
// Example2:
// [6,8,9,1,2] -> [1,2,6,8,9]

// Challenge
// In-place, O(1) extra space and O(n) time.

public class Solution {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int n=nums.size();
        // for (int i=0;i<n-1;i++){
        //     for (int j=0;j<n-1-i;j++){
        //         if (nums.get(j)>nums.get(j+1)){
        //             int tmp=nums.get(j);
        //             nums.set(j, nums.get(j+1));
        //             nums.set(j+1, tmp);
        //         }
        //     }
        // }

        //3-step reverse
        //Find Peak
        int peak=1;
        while (peak<n){
            if (nums.get(peak-1)>nums.get(peak)){
                break;
            }
            peak++;
        }
        //Merge Sort
        rotateNums(nums,0,peak-1);
        rotateNums(nums,peak,n-1);
        rotateNums(nums,0,n-1);
    }
    //Swap function
    private void rotateNums(List<Integer> nums, int left, int right){
        while (left<right){
            int tmp=nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, tmp);
            left++;
            right--;
        }
    }
}