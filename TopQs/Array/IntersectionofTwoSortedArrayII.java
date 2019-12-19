// Intersection of Two Arrays II

// Given two arrays, write a function to compute their intersection.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Note:

// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Two Pointers
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersections = new ArrayList<>();
        int i=0,j=0,k=0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else{
                intersections.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[intersections.size()];
        
        for (int each : intersections){
            result[k++] = each;
        }
        return result;
    }
}