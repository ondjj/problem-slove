package programmers.bfs;


import java.util.LinkedList;
import java.util.Queue;

public class ShortPath {
    static class Node {
        int data;
        Node rt, lt;

        Node(int data) {
            this.data = data;
            rt=lt=null;
        }
    }

    public int solution(int level, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                if (temp.lt == null && temp.rt == null) {
                    return level;
                }
                queue.offer(temp.lt);
                queue.offer(temp.rt);
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        ShortPath shortPath = new ShortPath();
        ShortPath.Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(shortPath.solution(0, root));
    }
}
