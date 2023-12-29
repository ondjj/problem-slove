package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBfs {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left=right=null;
        }
    }

    public void solution(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTreeBfs binaryTreeBfs = new BinaryTreeBfs();
        BinaryTreeBfs.Node root = new BinaryTreeBfs.Node(1);
        root.left = new BinaryTreeBfs.Node(2);
        root.right = new BinaryTreeBfs.Node(3);
        root.left.left = new BinaryTreeBfs.Node(4);
        root.left.right = new BinaryTreeBfs.Node(5);
        root.right.left = new BinaryTreeBfs.Node(6);
        root.right.right = new BinaryTreeBfs.Node(7);
        binaryTreeBfs.solution(root);
    }
}
