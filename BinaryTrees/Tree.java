class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }

        }
    }

    public void traversePreorder() {
        traversePreorder(root);
    }

    private void traversePreorder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreorder(root.leftChild);
        traversePreorder(root.rightChild);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(8);
        // System.out.print(tree);
        tree.traversePreorder();
    }
}
