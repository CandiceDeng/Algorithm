// Serialize and Deserialize BST

// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

// The encoded string should be as compact as possible.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //Level Oreder Traversal
        ArrayList<String> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null){
                arr.add("#");
            }else{
                arr.add(""+node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return String.join(",",arr);        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int head = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                TreeNode left = null, right = null;
                if (!arr[head].equals("#")){
                    left = new TreeNode(Integer.parseInt(arr[head]));
                }
                node.left = left;
                queue.offer(left);
                head++;
                if (!arr[head].equals("#")){
                    right = new TreeNode(Integer.parseInt(arr[head]));
                }
                node.right = right;
                queue.offer(right);
                head++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));