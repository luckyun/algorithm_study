package leetcode.easy;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    public static void main(String[] args) {
        SameTree st = new SameTree();
        TreeNode p = new TreeNode();
        p.val = 1;
        p.left = new TreeNode();
        p.left.val = 2;
        p.right = new TreeNode();
        p.right.val = 3;
        TreeNode q = new TreeNode();
        q.val = 1;
        q.left = new TreeNode();
        q.left.val = 2;
        q.right = new TreeNode();
        q.right.val = 3;

        System.out.println(st.isSameTree(p, q));

        p = new TreeNode();
        p.val = 1;
        p.left = new TreeNode();
        p.left.val = 2;
        q = new TreeNode();
        q.val = 1;
        q.left = null;
        q.right = new TreeNode();
        q.right.val = 2;
        System.out.println(st.isSameTree(p, q));

    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p == null && q == null){
           return true;
       } else if(p == null || q == null) {
            return false;
       } else if(p.val != q.val){
            return false;
       } else {
           return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
       }


    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
