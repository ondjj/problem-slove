package programmers.dfs;

import java.util.Scanner;

public class Combinations {
    private int[][] dy = new int[35][35];

    private int process(final int n, final int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = process(n - 1, r - 1) + process(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(c.process(n, r));
    }
}
