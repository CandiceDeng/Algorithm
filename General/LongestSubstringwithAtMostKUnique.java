// Longest Substring with At Most K Distinct Characters

// Given a string S, find the length of the longest substring T that contains at most k distinct characters.

// Example
// Example 1:

// Input: S = "eceba" and k = 3
// Output: 4
// Explanation: T = "eceb"
// Example 2:

// Input: S = "WORLD" and k = 4
// Output: 4
// Explanation: T = "WORL" or "ORLD"
// Challenge
// O(n) time

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int result = 0, left = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
            while (count.size() > k) {
                char cur = s.charAt(left);
                count.put(cur, count.get(cur)-1);
                if (count.get(cur) == 0) {
                    count.remove(cur);
                }
                left++;
            }
            result = Math.max(result, i-left+1);
        }
        return result;
    }
}