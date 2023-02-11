package ru.geekbrains.lesson4;

import java.util.List;

public class Tree {

    private Node root;
    private class Node {
        private int value;
        private List<Node> children;
    }

    /**
     *
     * @param value Искомое значение
     * @return Результат поиска элемента
     */
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
            for (Node child : node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}
