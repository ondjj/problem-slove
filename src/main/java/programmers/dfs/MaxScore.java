package programmers.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxScore {
    private static ArrayList<Problem> PROBLEM;
    private static int N, M, ANSWER;

    static class Problem {
        int score;
        int runtime;

        public int getScore() {
            return this.score;
        }

        public int getRuntime() {
            return this.runtime;
        }
    }

    public void maxScore(int level, int sum, int time) {
        if (time > M) {
            return;
        }
        if (level == N) {
            ANSWER = Math.max(ANSWER, sum);
            return;
        }
        Problem currentPS = PROBLEM.get(level);
        maxScore(level + 1, sum + currentPS.getScore(), time + currentPS.getRuntime());
        maxScore(level + 1, sum, time);
    }

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 문제 개수
        M = scanner.nextInt(); // 제한 시간
        PROBLEM = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt(); // 점수
            int b = scanner.nextInt(); // 시간
            Problem solve = new Problem();
            solve.score = a;
            solve.runtime = b;
            PROBLEM.add(solve);
        }
        maxScore.maxScore(0, 0, 0);
        System.out.println(ANSWER);
    }
}
