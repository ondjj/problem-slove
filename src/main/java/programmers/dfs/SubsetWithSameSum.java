package programmers.dfs;

import java.util.Scanner;

public class SubsetWithSameSum {
    private static int[] SET;
    private static int TOTAL;
    private static boolean flag = false;
    private static String ANSWER = "NO";

    public void subset(int level, int sum) {
        if (flag) return;
        if (sum > TOTAL / 2) return;
        if (level == SET.length) {
            if ((TOTAL - sum) == sum) {
                ANSWER = "YES";
                flag = true;
            }
        }else{
            subset(level + 1, sum + SET[level]);
            subset(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        SubsetWithSameSum subsetWithSameSum = new SubsetWithSameSum();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split(" ");
        SET = new int[n];
        TOTAL = 0;
        for (int i = 0; i < n; i++) {
            SET[i] = Integer.parseInt(numbers[i]);
            TOTAL += SET[i];
        }
        subsetWithSameSum.subset(0, 0);
        System.out.println(ANSWER);
    }
}
