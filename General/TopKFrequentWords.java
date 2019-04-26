// 692. Top K Frequent Words

// Given a non-empty list of words, return the k most frequent elements.

// Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

// Example 1:
// Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" and "love" are the two most frequent words.
//     Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:
// Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// Output: ["the", "is", "sunny", "day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//     with the number of occurrence being 4, 3, 2 and 1 respectively.
// Note:
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Input words contain only lowercase letters.
// Follow up:
// Try to solve it in O(n log k) time and O(n) extra space.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result=new ArrayList<>();
        Map<String, Integer> count=new HashMap<String, Integer>();
        if (words==null||words.length==0||k==0){
            return result;
        }
        for (String word:words){
            if (count.containsKey(word)){
                count.put(word, count.get(word)+1);
            }else{
                count.put(word, 1);
            }
        }
        //Convert HashMap Storage to List Strorage to sort
        List<Map.Entry<String, Integer>> list=new ArrayList<>(count.entrySet());
        list.sort(
            //Define new Comparator to determine order for words with same count
            new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2){
                if (p1.getValue()>p2.getValue()){
                    return -1;
                }
                if (p1.getValue().equals(p2.getValue())){
                    if (p1.getKey().compareTo(p2.getKey())<0){
                        return -1;
                    }
                    return 1;
                }
                if (p1.getValue()<p2.getValue()){
                    return 1;
                }
                return 0;
            }
        });
        for (int i=0;i<k;i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }
}

//Solution using PriorityQueue is in BFS folder