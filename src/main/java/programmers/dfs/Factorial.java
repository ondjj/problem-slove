package programmers.dfs;

public class Factorial {
    public int solution(int a) {
        if (a == 1) {
            return 1;
        }
        return a * solution(a - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.solution(5));
    }
}
