// Copy List with Random Pointer

// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

 

// Example 1:



// Input:
// {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

// Explanation:
// Node 1's value is 1, both of its next and random pointer points to Node 2.
// Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 

// Note:

// You must return the copy of the given head as a reference to the cloned list.

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head==null){
            return head;
        }
        initializeToNext(head);
        copyRandom(head);
        return splitList(head);
        // Node dummy = new Node(0); 
        // Map<Node,Node> mapping = new HashMap<>();
        // dummy.next = head;
        // Node prev = dummy;
        // Node newNode;
        // while (head!=null){
        //     if (mapping.containsKey(head)){
        //         newNode = mapping.get(head);
        //     }else{
        //         newNode = new Node(head.val);
        //         mapping.put(head,newNode);
        //     }
        //     prev.next = newNode;
        //     if (head.random!=null){
        //         if (mapping.containsKey(head.random)){
        //             newNode.random = mapping.get(head.random);
        //         }else{
        //             newNode.random = new Node(head.random.val);
        //             mapping.put(head.random,newNode.random);
        //         }
        //     }
        //     head = head.next;
        //     prev = newNode;
        // }       
        // return dummy.next;
    }
    private void initializeToNext(Node head){
        while (head!=null){
            Node newNode = new Node(head.val);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    private void copyRandom(Node head){
        while (head!=null){
            if (head.next.random!=null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private Node splitList(Node head){
        Node newHead = head.next;
        while (head!=null){
            Node cur = head.next;
            head.next = cur.next;
            head = head.next;
            if (cur.next!=null){
                cur.next = cur.next.next;
            }
        }
        return newHead;
    }
}