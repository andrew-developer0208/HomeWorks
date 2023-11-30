package algorithms;

/*
ДЗ: Необходимо превратить собранное на семинаре дерево поиска
в полноценное левостороннее красно-черное дерево.
И реализовать в нем метод добавления новых элементов с балансировкой.
 */

public class BinaryTree {
    Node root;
    enum Color {RED, BLACK}

    class Node{
        int value;
        Node left;
        Node right;
        Color color;
    }


    public boolean insert(int value){
        if(root == null){
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        }else{
            boolean result = insert(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
    }

    private boolean insert(Node node, int value){
        if(node.value == value){
            return false;
        }else{
            if(node.value < value){
                if(node.right != null){
                    boolean result = insert(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                }else{
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                    return true;
                }
            }else{
                if(node.left != null){
                    boolean result = insert(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                }else{
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                    return true;
                }
            }
        }
    }

    /**
     * Balances a red-black tree
     * @param node inserted Node instance
     * @return balanced subtree
     */
    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalabce;
        do {
            needRebalabce = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needRebalabce = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
            result.left.left != null && result.left.left.color == Color.RED) {
                needRebalabce = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needRebalabce = true;
                colorSwap(result);
            }
        }
        while (needRebalabce);
        return result;
    }

    /**
     * Swap node color
     * @param node Node
     */
    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    /**
     * Left swap subtree
     * @param node Node
     * @return Node
     */
    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    /**
     * Right swap subtree
     * @param node Node
     * @return Node
     */
    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    public boolean find(int value){
        return find(root, value);
    }

    private boolean find(Node node, int value){
        if(node == null){
            return false;
        }
        if(node.value == value){
            return true;
        }

        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

//        tree.insert(5);
//        System.out.println("finish");
//        tree.insert(3);
//        System.out.println("finish");
//        tree.insert(4);
//        System.out.println("finish");
//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(7);
//        tree.insert(8);
//        tree.insert(6);

        for (int i = 1; i < 20; i++) {
            tree.insert(i);
        }

        System.out.println(tree.find(2));
        System.out.println(tree.find(23));
    }
}
