package com.bintrees;

import com.company.Solution.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree(int rootValue) {
        root = new TreeNode(rootValue);
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree(10);
        t.getRoot().setLeft(new TreeNode(6));
        t.getRoot().setRight(new TreeNode(1));

        t.getRoot().getLeft().setLeft(new TreeNode((4)));
        t.getRoot().getLeft().setRight(new TreeNode((7)));
        System.out.println(t);
        boolean result = BinarySearchTree.verify(t);
        System.out.println(result);

    }

    public static boolean verify(BinarySearchTree t) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = t.getRoot();
        System.out.println(current.getValue());
        if (current != null) {
            stack.push(current);
        }
        if (!isLeftBranchValid(current, stack)) return false;
        while (!stack.isEmpty()) {
            current = stack.poll();
            System.out.println(current.getValue());
            if(!isRightNodeLeftBranchValid(current, stack)) return false;
            if(!isLeftBranchValid(current, stack)) return false;
        }
        return true;
    }
    private static boolean isRightNodeLeftBranchValid(TreeNode current,Deque<TreeNode>  stack){
        if (current.getRight() != null) {
            if (current.getValue() < current.getRight().getValue()) return false;
            if (!isLeftBranchValid(current.getRight(), stack)) return false;
        }
        return true;
    }
    private static boolean isLeftBranchValid(TreeNode cur, Deque<TreeNode> stack) {
        System.out.println("starting at " + cur.getValue());
        while (cur.getLeft() != null) {
            System.out.println(cur.getValue());
            if (cur.getLeft().getValue() > cur.getValue()) return false;
            cur = cur.getLeft();
            stack.push(cur);
        }
        return true;
    }

    public TreeNode getRoot() {
        return root;
    }

    public String toString() {
        return root.toString("");
    }

}
