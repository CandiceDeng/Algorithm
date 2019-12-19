// Intersection of Two Arrays

// Given two arrays, write a function to compute their intersection.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Note:

// Each element in the result must be unique.
// The result can be in any order.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //HashSet
        // Set<Integer> intersections1 = new HashSet<>();
        // Set<Integer> intersections2 = new HashSet<>();
        // for (int i : nums1){
        //     intersections1.add(i);
        // }
        // for (int j : nums2){
        //     if (intersections1.contains(j)){
        //         intersections2.add(j);
        //     }            
        // }
        // int[] result = new int[intersections2.size()];
        // int i = 0;
        // for (int each : intersections2){
        //     result[i++] = each;
        // }
        // return result;
        
        //Two pointers
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
                if (intersections.isEmpty()||
                    intersections.get(intersections.size()-1)!=nums1[i]){
                    intersections.add(nums1[i]);
                }
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