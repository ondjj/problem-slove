package programmers.dfs;

import java.util.Scanner;

public class GuessSequence {
    private static int n,m;
    private static int[] b,p,check;
    private boolean flag = false;
    private int[][] dy = new int[35][35];

    public static void main(String[] args) {
        GuessSequence guessSequence = new GuessSequence();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        b = new int[n];
        p = new int[n];
        check = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = guessSequence.combination(n - 1, i);
        }
        guessSequence.dfs(0, 0);
    }

    private void dfs(final int L, final int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == m){
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        }else{
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    p[L] = i;
                    dfs(L + 1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    private int combination(final int n, final int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) return 1;
        else{
            return dy[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}
