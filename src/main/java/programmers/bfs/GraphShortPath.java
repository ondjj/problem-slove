package programmers.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GraphShortPath {
    private static List<ArrayList<Integer>> graph;
    private static int[] dis, check;
    private static int n, m;

    public void shortPath(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int nextNode : graph.get(currentNode)) {
                if (check[nextNode] == 0) {
                    check[nextNode] = 1;
                    queue.offer(nextNode);
                    dis[nextNode] = dis[currentNode] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphShortPath graphShortPath = new GraphShortPath();
        Scanner scanner = new Scanner(System.in);
        graph = new ArrayList<>();
        n = scanner.nextInt();
        m = scanner.nextInt();
        dis = new int[n + 1];
        check = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        check[1] = 1;
        graphShortPath.shortPath(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
