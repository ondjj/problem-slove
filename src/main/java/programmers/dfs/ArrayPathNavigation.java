package programmers.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayPathNavigation {
    private static List<List<Integer>> graph;
    private static int[] check;
    private static int n, m, answer = 0;

    public void arrayNavigation(int vertex) {
        if (vertex == n) {
            answer++;
            return;
        }
        for (int nextVertex : graph.get(vertex)) {
            if (check[nextVertex] == 0) {
                check[nextVertex] = 1;
                arrayNavigation(nextVertex);
                check[nextVertex] = 0;
            }
        }
    }

    public static void main(String[] args) {
        ArrayPathNavigation arrayPathNavigation = new ArrayPathNavigation();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new ArrayList<>();
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
        arrayPathNavigation.arrayNavigation(1);
        System.out.println(answer);
    }
}
