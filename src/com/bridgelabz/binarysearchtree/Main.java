package com.bridgelabz.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        System.out.println("!!! welcome to binary search tree problem !!!");
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.add(56);
        binaryTree.add(30);
        binaryTree.add(70);
        binaryTree.add(60);
        binaryTree.add(95);
        binaryTree.add(22);
        binaryTree.add(40);
        binaryTree.add(11);
        binaryTree.add(3);
        binaryTree.add(16);
        binaryTree.add(65);
        binaryTree.add(63);
        binaryTree.add(67);
        System.out.println("Height of tree : " + binaryTree.getHeightOfTree());

        binaryTree.inorder();

        System.out.println(binaryTree);
    }
}
