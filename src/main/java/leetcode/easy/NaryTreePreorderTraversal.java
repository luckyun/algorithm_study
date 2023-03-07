package leetcode.easy;

/**
 * 589. N-ary Tree Preorder Traversal
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */

import java.util.ArrayList;
import java.util.List;


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        NaryTreePreorderTraversal nAryTree = new NaryTreePreorderTraversal();

        List<Node> lev2Child = new ArrayList<>();
        lev2Child.add(new Node(5));
        lev2Child.add(new Node(6));
        List<Node> lev1Child = new ArrayList<>();
        lev1Child = new ArrayList<>();
        lev1Child.add(new Node(3, lev2Child));
        lev1Child.add(new Node(2));
        lev1Child.add(new Node(4));
        Node  inp1 = new Node(1, lev1Child);

        //int[] inp2 = new int[]{1,-1,2,3,4,5,-1,-1,6,7,-1,8,-1,9,10,-1,-1,11,-1,12,-1,13,-1,-1,14};
        NaryTreePreorderTraversal nTree = new NaryTreePreorderTraversal();
        System.out.println(nTree.preorder((Node) inp1));

    }

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        return traversTree(root, ans);
    }
    public List<Integer> traversTree(Node root, List<Integer> ans){
        if(root == null){
            return ans;
        }
        ans.add(root.val);


        if(root.children == null){
            return ans;
        }
        for (Node node : root.children) {
            traversTree(node, ans);
        }

        return  ans;
    }


}
