// Combination Sum

// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

// The same repeated number may be chosen from candidates unlimited number of times.

// Note:

// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:

// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//   [7],
//   [2,2,3]
// ]
// Example 2:

// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates==null || candidates.length==0){
            return result;
        }
        
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
            if (i!=0&&candidates[i]==candidates[i-1]){
                continue; //Remove duplicates
            }
            combination.add(candidates[i]);
            recursion(candidates,i,remainTarget-candidates[i],combination,result);
            combination.remove(combination.size()-1);
        }
    }
}