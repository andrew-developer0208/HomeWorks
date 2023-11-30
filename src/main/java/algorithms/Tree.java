package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;

    /**
     * Обход дерева в глубину
     * @param node
     * @param value
     * @return
     */
    private Node findDepth(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child: node.children) {
                Node result = findDepth(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * Поиск в ширину
     * @param value
     * @return
     */
    private Node findWidth(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node: line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    /**
     * Checks value existing
     * @param value
     * @return
     */
    public boolean exist(int value) {
        if (root != null) {
            Node node = findDepth(root, value);
            return node != null;
        }
        return false;
    }

    public class Node {
        int value;
        List<Node> children;
    }
}
