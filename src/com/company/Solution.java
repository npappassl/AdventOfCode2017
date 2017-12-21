package com.company;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(4, null);

        TreeNode leftNode = new TreeNode(2, tree);
        tree.setLeft(leftNode);

        TreeNode rightNode = new TreeNode(6, tree);
        tree.setRight(rightNode);

        leftNode.setLeft(new TreeNode(1, leftNode));
        leftNode.setRight(new TreeNode(3, leftNode));

        rightNode.setLeft(new TreeNode(5, rightNode));
        rightNode.setRight(new TreeNode(7, rightNode));
        System.out.println("Starting from "+ tree.left.right.getValue());
        System.out.println(tree.left.right.getNext().getValue());
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
        public TreeNode(int value){
            this.value = value;
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
            if(right!=null) return goLeft(right);
            TreeNode t = this;
            while(t.parentNode!=null&&t!=t.parentNode.left&& t.parentNode.getValue()<t.getValue()){
                System.out.println(t);
                t=t.parentNode;
            }
            return goLeft(t.right);
        }
        private TreeNode goLeft(TreeNode t){
            while(t.left!=null){
                t=t.left;
            }
            return t;
        }
        public String toString(String carry){
            carry+=this.getValue()+",";
            if(left == null && right == null) return carry+"#";
            if(left != null && right != null) return left.toString(carry) + right.toString(carry);
            if(right != null) return right.toString(carry);
            if(left != null) return left.toString(carry);

            return carry;
        }

        public String toString(){
            return Integer.toString(this.getValue());
        }
        public TreeNode getNext() {
            return findNext(this.value);
        }
    }
}
