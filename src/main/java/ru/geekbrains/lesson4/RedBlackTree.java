package ru.geekbrains.lesson4;

public class RedBlackTree extends BinaryTree {
    private Node root;

//    public RedBlackTree(){
//        root.isBlack = true;
//
//    }

    /**
     * @param root Вершина дерева.
     */
    public RedBlackTree(int root) {
        this.root = new Node();
        this.root.value = root;
        this.root.isBlack = true;
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
        if (exist(value)) return false;
        else {
            return findNode(root, value) != null;
        }
    }

    private Node findNode(Node node, int value) {
        if (node.value > value) {
            if (node.leftChild != null)
                return findNode(node.leftChild, value);
            else {
                node.leftChild = new Node();
                node.leftChild.value = value;
                node.leftChild.isBlack = false;
                return node.leftChild;
            }
        } else if (node.rightChild != null)
            return findNode(node.rightChild, value);
        else {
            node.rightChild = new Node();
            node.rightChild.value = value;
            node.rightChild.isBlack = false;
            return node.rightChild;

        }
    }


    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        private boolean isBlack;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isBlack() {
            return isBlack;
        }

        public void setBlack(boolean black) {
            isBlack = black;
        }


    }


}
