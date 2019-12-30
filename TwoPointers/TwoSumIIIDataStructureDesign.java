// Two Sum III - Data structure design

// Design and implement a TwoSum class. It should support the following operations: add and find.

// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

// Example
// Example 1:

// add(1); add(3); add(5);
// find(4) // return true
// find(7) // return false

public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    private HashMap<Integer,Integer> map;
    public TwoSum(){
        map = new HashMap<>();
    }
    public void add(int number) {
        // write your code here
        if (map.containsKey(number)){
            map.put(number,map.get(number)+1);
        }else{
            map.put(number,1);
        }
    }
    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for (Integer key : map.keySet()){
            int target = value - key;
            if (map.containsKey(target)){
                if (target!=key || map.get(key)>1){
                    return true;
                }
            }
        }
        return false;
    }
}