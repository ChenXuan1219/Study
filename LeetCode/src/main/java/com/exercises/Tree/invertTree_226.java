package com.exercises.Tree;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/28 15:14
 */
public class invertTree_226 {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root){
        return root;
    }
}



class TreeNode {
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

