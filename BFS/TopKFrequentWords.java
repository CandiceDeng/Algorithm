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

class Pair {
    String word;
    int frequency;
    public Pair(String word, int frequency){
        this.word=word;
        this.frequency=frequency;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        if (p1.frequency!=p2.frequency){
            return p1.frequency-p2.frequency;
        }
        return p2.word.compareTo(p1.word);
    }
}

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
        Queue<Pair> pq=new PriorityQueue<Pair>(k, new PairComparator());
        for (Map.Entry<String, Integer> word:count.entrySet()){
            Pair pair=new Pair(word.getKey(), word.getValue());
            pq.offer(pair);
            if (pq.size()>k){
                pq.poll();
            }
        }
        while (!pq.isEmpty()){
            result.add(pq.poll().word);
        }
        Collections.reverse(result);
        return result;
    }
}