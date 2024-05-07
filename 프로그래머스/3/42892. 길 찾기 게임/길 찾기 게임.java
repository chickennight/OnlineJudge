import java.util.*;

class Solution { 
    private class Node {
        int x, y, value;
        Node left, right;
        
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    private int[][] result;
    private int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;
        
        Node[] nodes = new Node[size];
        for(int i = 0; i < size; ++i) 
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y) return o1.x - o2.x;
            else return o2.y - o1.y;
        });
        
        Node root = nodes[0];
        for(int i = 1; i < nodes.length; ++i) 
            insert(root, nodes[i]); 
        
        result = new int[2][size];
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return result;
    }
    
    private void insert(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    private void preorder(Node root) {
        if(root != null) {
            result[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.value;
        }
    }

}