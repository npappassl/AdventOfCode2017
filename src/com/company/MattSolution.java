package com.company;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class MattSolution {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4, null);

        TreeNode leftNode = new TreeNode(2, tree);
        tree.setLeft(leftNode);

        TreeNode rightNode = new TreeNode(6, tree);
        tree.setRight(rightNode);

        leftNode.setLeft(new TreeNode(1, leftNode));
        leftNode.setRight(new TreeNode(3, leftNode));

        // rightNode.setLeft(new TreeNode(5, rightNode));
        rightNode.setRight(new TreeNode(7, rightNode));


        System.out.println(tree.getNext().getValue());

        System.out.println(rightNode.getNext().getValue());
    }


    public static class TreeNode {
        private final int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parentNode;

        public TreeNode(int value, TreeNode parentNode) {
            this.value = value;
            this.parentNode = parentNode;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getParentNode() {
            return this.parentNode;
        }

        private TreeNode findNext(int value) {

            if (this.value < value) {
                if (this.right == null) {
                    return this;
                }
                return this.right.findNext(value);

            } else {
                if (this.left == null) {
                    return this;
                }
                return this.left.findNext(value);
            }

        }

        public TreeNode getNext() {

            if (this.right == null) {
                return this;
            }

            return this.right.findNext(this.value);
        }
    }
}
