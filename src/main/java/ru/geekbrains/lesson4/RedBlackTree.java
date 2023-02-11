package ru.geekbrains.lesson4;

public class RedBlackTree extends BinaryTree {
    private Node root;

    {
        root.isBlack = true;
    }

    /**
     * @param value Искомое значение
     * @return Результат поиска элемента
     */

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

    public boolean add(int value) {
        if (root == null) {
            root.value = value;
            return true;
        } else {
            Node node = root;
            boolean flag = false;
            while (!flag) {
                if (node.value > value) {
                    node = node.leftChild;
                    if (node == null) {
                        node.leftChild = new Node(value);
                        flag = true;
                    }
                } else {
                    node = node.rightChild;
                    if (node == null) {
                        node = new Node(value);
                        flag = true;
                    }
                }
            }
            node.isBlack = false;

        }

        return false;
    }

    private Node findNode(Node node, int value) {
        if (node.value > value) {
            if (node.leftChild != null)
                return find(node.leftChild, value);
            else {
                node.leftChild = new Node(value);
                return node.leftChild;
            }
        } else if (node.rightChild != null)
            return find(node.rightChild, value);
        else {
            node.rightChild = new Node(value);
            return node.rightChild;

        }
    }


    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        private boolean isBlack;

        public Node() {
            this(0);
        }

        public Node(int value) {
            this.value = value;
        }
    }


}
