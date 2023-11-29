package com.bridgelabz.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        System.out.println("!!! welcome to binary search tree problem !!!");
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.add(56);
        binaryTree.add(30);
        binaryTree.add(70);
        binaryTree.inorder();
        System.out.println();
        System.out.println(binaryTree);
    }
}
