package programmers.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicatePermutation {
    private static int N,M;
    private static int[] ARR;

    public void permutation(int level) {
        if (level == ARR.length) {
            System.out.println(Arrays.toString(ARR));
        }else{
            for (int i = 1; i <= N; i++) {
                ARR[level] = i;
                permutation(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        DuplicatePermutation duplicatePermutation = new DuplicatePermutation();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        ARR = new int[M];

        duplicatePermutation.permutation(0);
    }
}
