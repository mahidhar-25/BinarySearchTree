package com.bridgelabz.binarysearchtree;
/*
@desc : Class node is a generic class it contains and data and a next pointer of type T which we initialize

 */
    public class INode<T>{
        T data;
        INode<T> right;
        INode<T> left;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", right=" + right +
                ", left=" + left +
                '}';
    }

    /*
            @desc : constructor initializing node with value d of type T(object)
            @param - T(Type object primitive) - data
            @return : no return
             */
        INode(T data){
            this.data = data;
            right = null;
            left = null;
        }
    }
