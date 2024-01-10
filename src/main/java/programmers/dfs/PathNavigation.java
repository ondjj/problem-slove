package programmers.dfs;

import java.util.Scanner;

public class PathNavigation {
    private static int[][] graph;
    private static int[] check;
    private static int n, m, answer = 0;

    public void navigate(int x) {
        if (x == n) {
            answer++;
            return;
        }
        for (int i = 1; i < graph.length; i++) {
            if (graph[x][i] == 1 && check[i] == 0) {
                check[i] = 1;
                navigate(i);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        PathNavigation pathNavigation = new PathNavigation();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n + 1][n + 1];
        check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        check[1] = 1;
        pathNavigation.navigate(1);
        System.out.println(answer);
    }
}
