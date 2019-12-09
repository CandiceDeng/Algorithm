// Subsets

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums==null){
            return result;
        }
        if (nums.length==0){
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> subset = new ArrayList<>();
        recursion(result,subset,0,nums);
        return result;        
    }
    private void recursion(List<List<Integer>> result,List<Integer> subset,int startIndex,int[] nums){
        result.add(new ArrayList<>(subset)); //Deep copy
        for (int i=startIndex;i<nums.length;i++){
            subset.add(nums[i]);
            recursion(result,subset,i+1,nums);
            subset.remove(subset.size()-1); //Backtracking to the subset before recursion
        }
    }
}