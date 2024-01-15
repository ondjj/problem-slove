package programmers.dfs;

import java.util.Scanner;

public class Riding {
    private static int weight, answer;
    private static int[] dogs;

    public void heavyWeight(int level, int sum) {
        if (sum > weight) {
            return;
        }
        if (level == dogs.length) {
            answer = Math.max(answer, sum);
        } else {
            heavyWeight(level + 1, sum + dogs[level]);
            heavyWeight(level + 1, sum);
        }
    }

    public static void main(String[] args) {
        Riding riding = new Riding();
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextInt();
        dogs = new int[scanner.nextInt()];

        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = scanner.nextInt();
        }
        riding.heavyWeight(0, 0);
        System.out.println(answer);
    }
}
