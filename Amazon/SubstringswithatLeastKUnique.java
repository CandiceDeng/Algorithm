// Substring With At Least K Distinct Characters

// Given a string S with only lowercase characters.

// Return the number of substrings that contains at least k distinct characters.

// 10 ≤ length(S) ≤ 1,000,000
// 1 ≤ k ≤ 26
// Have you met this question in a real interview?  
// Example
// Example 1:

// Input: S = "abcabcabca", k = 4
// Output: 0
// Explanation: There are only three distinct characters in the string.
// Example 2:

// Input: S = "abcabcabcabc", k = 3
// Output: 55
// Explanation: Any substring whose length is not smaller than 3 contains a, b, c.
//     For example, there are 10 substrings whose length are 3, "abc", "bca", "cab" ... "abc"
//     There are 9 substrings whose length are 4, "abca", "bcab", "cabc" ... "cabc"
//     ...
//     There is 1 substring whose length is 12, "abcabcabcabc"
//     So the answer is 1 + 2 + ... + 10 = 55.










// Count substrings with exact k unique characters

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        long result=0;
        int slen=s.length();
        int count[]=new int[26];
        for (int i=0;i<slen;i++){
            int dist=0;
            Arrays.fill(count, 0);
            for (int j=i;j<slen;j++){
                if (count[s.charAt(j)-'a']==0){
                    dist++;
                    count[s.charAt(j)-'a']+=1;
                }
                if (dist==k){
                    result++;
                }
            }
        }
       return result; 
    }
}