package programmers.dfs;

public class BinaryTree {
    static class Node {
        int data;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public void solution(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        solution(node.left);
        solution(node.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        binaryTree.solution(root);
    }
}
