package com.edu.practice.io;

public class A8_LowestCommonAncestor {

    private static EduTreeNode solution (EduTreeNode p, EduTreeNode q) {
        EduTreeNode a = p;
        EduTreeNode b = q;

        while (a!=b) {
            a = a!=null ? a.parent :q;
            b = b!=null ? b.parent :p;
        }
        return a;
    }

    public static void main(String[] args) {
        // Create nodes
        EduTreeNode root = new EduTreeNode(3);
        EduTreeNode node5 = new EduTreeNode(5);
        EduTreeNode node1 = new EduTreeNode(1);
        EduTreeNode node6 = new EduTreeNode(6);
        EduTreeNode node2 = new EduTreeNode(2);
        EduTreeNode node0 = new EduTreeNode(0);
        EduTreeNode node8 = new EduTreeNode(8);

        // Build tree
        root.left = node5;
        root.right = node1;
        node5.parent = root;
        node1.parent = root;

        node5.left = node6;
        node5.right = node2;
        node6.parent = node5;
        node2.parent = node5;

        node1.left = node0;
        node1.right = node8;
        node0.parent = node1;
        node8.parent = node1;

        // Call LCA
        A8_LowestCommonAncestor sol = new A8_LowestCommonAncestor();
        EduTreeNode lca = sol.solution(node6, node2);

        if (lca != null) {
            System.out.println("LCA of 6 and 2 is: " + lca.data);
        } else {
            System.out.println("LCA not found");
        }
    }

}

 class EduTreeNode {
     int data;
     EduTreeNode left;
     EduTreeNode right;
     EduTreeNode parent;

     EduTreeNode(int value) {
         this.data = value;
         this.left = null;
         this.right = null;
         this.parent = null;
     }
 }