// Window Sum

// Given an array of n integers, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

// Example
// Example 1

// Input：array = [1,2,7,8,5], k = 3
// Output：[10,17,20]
// Explanation：
// 1 + 2 + 7 = 10
// 2 + 7 + 8 = 17
// 7 + 8 + 5 = 20

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums.length == 0){
            return nums;
        }
        int[] result = new int[nums.length-k+1];
        int start = 0,stop = nums.length-k;
        int i = 0;
        while (start<=stop){
            result[i++] = eachSum(nums,k,start++);
        }
        return result;
    }
    private int eachSum(int[] nums,int k,int start){
        int total = 0;
        for (int i=start;i<k+start;i++){
            total += nums[i];
        }
        return total;
    }
}