package leetcode.easy;




public class SearchBinarySearchTree {
    // https://leetcode.com/problems/search-in-a-binary-search-tree/


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode();
        treeNode.left.val = 2;
        treeNode.left.left = new TreeNode();
        treeNode.left.left.val = 1;
        treeNode.left.right = new TreeNode();
        treeNode.left.right.val = 3;

        treeNode.right = new TreeNode();
        treeNode.right.val = 7;






        System.out.println(new SearchBinarySearchTree().searchBST(treeNode, 2));

    }

    //구현
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result = null;
        if(root.val == val){
            result = root;
        } else if(root.val > val && root.left != null){
            result = searchBST(root.left, val);
        } else if(root.val < val && root.right != null){
            result = searchBST(root.right, val);
        }



        return result;
    }


    static public class TreeNode {
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
