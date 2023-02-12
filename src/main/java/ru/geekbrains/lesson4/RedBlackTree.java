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
            findNode(value);
            return true;
        }
    }

    private void findNode(int value) {
        Node node = root;
        Node parent = null;

        while (node != null) {
            parent = node;
            if (value < node.value) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }

        Node addNode = new Node(value);
        if (parent == null) {
            root = addNode;
        } else if (value < parent.value) {
            parent.leftChild = addNode;
        } else {
            parent.rightChild = addNode;
        }
        addNode.parent = parent;
        balanceTree(addNode);
    }

    public void balanceTree(Node node) {
        Node parent = node.parent;

        if (parent == null) {
            node.isBlack = true;
            return;
        }
        if (parent.isBlack) {
            return;
        }
        Node temp = parent.parent;
        Node temp2;

        if (temp == null) {
            parent.isBlack = true;
            return;
        }

        if (temp.leftChild == parent) {
            temp2 = temp.rightChild;

        } else {
            temp2 = temp.leftChild;
        }

        if (temp2 != null && !temp2.isBlack) {
            changeColor(parent.parent);
            balanceTree(parent.parent);
        } else if (parent == parent.parent.leftChild) {
            if (node == parent.rightChild) {
                leftTurn(parent);
                parent = node;
            }
            rightTurn(temp);
            parent.isBlack = true;
            temp.isBlack = false;
        }
        else {
            if (node == parent.leftChild) {
                rightTurn(parent);
                parent= node;
            }
            leftTurn(temp);
            parent.isBlack = true;
            temp.isBlack = false;
        }


    }


    public void leftTurn(Node node) {
        Node parent = node.parent;
        Node rightChild = node.rightChild;

        node.rightChild = rightChild.leftChild;
        if (rightChild.leftChild != null) {
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
        if (leftChild.rightChild != null) {
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
        if (X.isBlack) {
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


        public Node(int value) {
            this.value = value;
            this.isBlack = false;
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
