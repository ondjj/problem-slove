package programmers;

public class Fibonacci {
    private static int[] numbers;

    public int solution(int fibo) {
        if (numbers[fibo] != 0) {
            return numbers[fibo];
        }
        return numbers[fibo] = solution((fibo - 2)) + solution((fibo - 1));
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int number = 7;
        numbers = new int[number + 1];
        numbers[1] = 1;
        numbers[2] = 1;
        for (int i = 1; i < number + 1; i++) {
            System.out.print(fibonacci.solution(i) + " ");
        }
    }
}
