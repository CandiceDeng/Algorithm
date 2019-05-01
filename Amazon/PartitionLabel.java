// Partition Labels

// A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

// Example 1:
// Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
// Note:

// S will have length in range [1, 500].
// S will consist of lowercase letters ('a' to 'z') only.

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result=new ArrayList<>();
        int size=S.length();
        Map<Character, Integer> map=new HashMap<>();
        for (int i=0;i<size;i++){
            map.put(S.charAt(i), i);
        }
        int start=0, end=0;
        for (int j=0;j<size;j++){
            end=Math.max(map.get(S.charAt(j)), end);
            if (j==end){
                result.add(j-start+1);
                start=j+1;
            }
        }
        return result;
    }
}