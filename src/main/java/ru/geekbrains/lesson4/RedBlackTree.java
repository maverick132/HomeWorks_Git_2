package ru.geekbrains.lesson4;

public class RedBlackTree extends BinaryTree {
    private Node root;

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

    /**
     * @param X Дите, которое должно стать родителем
     * @param Y Родитель, который должен стать дитем
     */
    public void leftTurn(Node node) {
        Node parent = node.parent;
        Node rightChild = node.rightChild;

        node.rightChild = rightChild.leftChild;
        if(rightChild.leftChild !=null){
            rightChild.leftChild.parent = node;
        }

        rightChild.leftChild = node;
        node.parent = rightChild;

        if (parent == null) {
            root = rightChild;
        } else if (parent.leftChild == node) {
            parent.leftChild = rightChild;
        } else if (parent.rightChild == node) {
            parent.rightChild = rightChild;
        }

        if (rightChild != null) {
            rightChild.parent = parent;
        }
    }
    public void rightTurn(Node node) {
        Node parent = node.parent;
        Node leftChild = node.leftChild;

        node.leftChild = leftChild.rightChild;
        if(leftChild.rightChild !=null){
            leftChild.rightChild.parent = node;
        }

        leftChild.rightChild = node;
        node.parent = leftChild;

        if (parent == null) {
            root = leftChild;
        } else if (parent.leftChild == node) {
            parent.leftChild = leftChild;
        } else if (parent.rightChild == node) {
            parent.rightChild = leftChild;
        }

        if (leftChild != null) {
            leftChild.parent = parent;
        }
    }
    public void changeColor(Node X) {
        if (X.isBlack){
            X.isBlack = false;
            X.leftChild.isBlack = true;
            X.rightChild.isBlack = true;
        }
    }


    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        private Node parent;
        private boolean isBlack;
        {
            isBlack = false;
        }
        public void copyNode(Node Y) {
            if (Y.rightChild != null) this.rightChild = Y.rightChild;
            this.isBlack = Y.isBlack;
            if (Y.leftChild != null) this.leftChild = Y.leftChild;
            this.value = Y.value;
            if (Y.parent != null) this.parent = Y.parent;

        }

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
