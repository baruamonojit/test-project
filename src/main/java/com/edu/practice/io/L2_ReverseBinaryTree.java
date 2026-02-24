package com.edu.practice.io;

import com.sun.source.tree.Tree;

public class L2_ReverseBinaryTree {

    private static void solution(TreeNode root) {
        if (root==null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        solution(root.left);
        solution(root.right);
    }

    private static void inorder (TreeNode root) {

        if (root ==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                4
              /   \
             2     7
            / \   / \
           1   3 6   9
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println("Before Inversion (Inorder):");
        inorder(root);

        solution(root);

        System.out.println("\nAfter Inversion (Inorder):");
        inorder(root);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
