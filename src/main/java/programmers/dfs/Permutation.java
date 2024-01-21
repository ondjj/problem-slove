package programmers.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    private static int n,m;
    private static int[] list, check;

    public void process(int level, int[] arr) {
        if (level == m) {
            System.out.println(Arrays.toString(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                list[level] = arr[i];
                process(level + 1, arr);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] arr = new int[n];
        check = new int[n];
        list = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        permutation.process(0, arr);
    }
}
