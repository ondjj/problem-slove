package programmers.dfs;

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
        if (node.lt == null && node.rt == null) {
            return level;
        }
        return Math.min(solution(level + 1, node.lt), solution(level + 1, node.rt));
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
