package com.bridgelabz.binarysearchtree;

/*
@desc :
this binary search tree class where it extends the node class and updates the node class with two pointer  it has multiple methods and
root node , methods includes traversal , searching , adding , deleting nodes.
 */

public class BinarySearchTree<T extends Comparable<T>>  {
    private INode<T> root;

/*

 @desc : Inserts a new element with the specified value according to binary search tree given type T.

 @param val The value to be inserted of type T.

 @return : Node<T>

 */

    private INode<T> insert(INode<T> newNode , T val){

        if(newNode == null){
            return new INode<T>(val);
        }else{
            if(val.compareTo(newNode.data) < 0){
                newNode.left = insert(newNode.left , val);
            }else{
                newNode.right = insert(newNode.right , val);
            }
        }
        return newNode;
    }

    /*
         @desc : delete the  element based on the key given if it is not null.

         @param : no params.

        @return : Node<T>

         */
    private INode<T> deleteNode(INode<T> node , T key){
        if (node == null)
            return null;

        // Recursive calls for ancestors of
        // node to be deleted
        if (key.compareTo(node.data) < 0) {
            node.left = deleteNode(node.left, key);
            return node;
        } else if (key.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, key);
            return node;
        }

        // We reach here when root is the node
        // to be deleted.

        // If one of the children is empty
        if (node.left == null) {
            INode<T> temp = node.right;
            return temp;
        } else if (node.right == null) {
            INode<T> temp = node.left;
            return temp;
        }

        // If both children exist
        else {

            INode<T> succParent = node;

            // Find successor
            INode<T> succ = node.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != node)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            // Copy Successor Data to root
            node.data = succ.data;

            // Delete Successor and return root
            return node;
        }

    }

    /*

    @desc :  This method traverses the linked list and find the node with given data key.

    @param :  Type T , val.

      @return : Node<T>
*/
    private INode<T> search(INode<T> node , T val){
        if (node == null || val.equals(node.data))
            return node;

        // Key is greater than root's key
        if (val.compareTo(node.data) > 0)
            return search(node.right, val);

        // Key is smaller than root's key
        return search(node.left, val);
    }
    /*
        @desc :  This method traverses the linked list and prints each element.
        @param :  None.
        @return :  No explicit return value.
 */
    public void inorder() {
        inorder(root);
    }
    /*
        @desc :  This method traverses the linked list and prints each element.
        @param :  None.
        @return :  No explicit return value.
 */
    private void inorder(INode<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

/*
@desc: Calculates and returns the size of the subtree rooted at the given node.
@param: node - The root node of the subtree for which size is to be calculated.
@return: The size of the subtree.
 */
    public int size(INode<T> node)
    {
        if (node == null)
            return 0;
        else
            return (size(node.left) + 1 + size(node.right));
    }

/*
@desc: Constructor for initializing a new binary search tree with no elements.
@param: No parameters.
@return: No return value.
 */
    public BinarySearchTree() {
        root = null;
    }
/*
    @desc: Provides a string representation of the binary search tree.
    @param: No parameters.
   @return: A string representing the binary search tree.

   */
    @Override

    public String toString() {
        return "BinarySearchTree{" +
                ", root=" + root +
                '}';
    }
/*
@desc: Retrieves the root node of the binary search tree.
@param: No parameters.
@return: The root node of the binary search tree.
 */
    public INode<T> getRoot() {
        return root;
    }
/*
@desc: Adds a new value to the binary search tree.
@param: val - The value to be added to the binary search tree.
@return: No return value.
 */
    public void add(T val){
         root = insert(root ,val );
    }

/*
@desc: Deletes a value from the binary search tree.
@param: val - The value to be deleted from the binary search tree.
@return: No return value.
 */
    public void delete(T val){
        root =  deleteNode(root , val);
    }
/*
@desc: Calculates and returns the size of the entire binary search tree.
@param: No parameters.
@return: The size of the binary search tree.
 */
    int size() {
        return size(root);
    }

    /*
    @desc: Searches for a value in the binary search tree and returns the corresponding node.
@param: val - The value to be searched in the binary search tree.
@return: The node containing the searched value or null if not found.
     */
    public INode<T> search(T val){
        return search(root, val);
    }

    /* computes number of nodes in tree */

}
