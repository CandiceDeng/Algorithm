// Combination Sum II

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

// Each number in candidates may only be used once in the combination.

// Note:

// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5,
// A solution set is:
// [
//   [1,2,2],
//   [5]
// ]

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates==null || candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        recursion(candidates,0,target,combination,result);
        return result;
        
    }
    private void recursion(int[] candidates,int startIndex,int remainTarget,List<Integer> combination,List<List<Integer>> result){
        if (remainTarget==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i=startIndex;i<candidates.length;i++){
            if (remainTarget<0){
                break;
            }
            if (i!=startIndex&&candidates[i]==candidates[i-1]){
                continue; //Remove duplicates in combination
            }
            combination.add(candidates[i]);
            recursion(candidates,i+1,remainTarget-candidates[i],combination,result);
            combination.remove(combination.size()-1);
        }
    }
}