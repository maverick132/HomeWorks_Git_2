package ru.geekbrains.lesson4;

public class BinaryTree extends Tree {

    private Node root;
    @Override
    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    return find(node.leftChild, value);
                } else return null;
            } else {
                if (node.rightChild != null) {
                    return find(node.rightChild, value);
                } else
                    return null;
            }
        }
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
    }


}
