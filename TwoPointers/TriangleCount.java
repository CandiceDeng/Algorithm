// Triangle Count

// Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

// Example
// Example 1:

// Input: [3, 4, 6, 7]
// Output: 3
// Explanation:
// They are (3, 4, 6), 
//          (3, 6, 7),
//          (4, 6, 7)
// Example 2:

// Input: [4, 4, 4, 4]
// Output: 4
// Explanation:
// Any three numbers can form a triangle. 
// So the answer is C(3, 4) = 4

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        int count = 0;
        Arrays.sort(S);
        //Start to loop from the greatest number
        for (int i=S.length-1;i>0;i--){
            int small=0, big=i-1;
            while (small<big){
                if (S[small]+S[big]>S[i]){
                    count+=big-small; //Any item after small plus big will greater than S[i]
                    big--;
                }else{
                    small++;
                }
            }
        }
        return count;
    }
}
