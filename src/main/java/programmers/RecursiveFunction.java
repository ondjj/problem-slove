package programmers;

public class RecursiveFunction {
    public void solution(int a) {
        if (a <= 0) {
            return;
        }
        solution(a - 1);
        System.out.print(a + "\t");
    }

    public static void main(String[] args) {
        RecursiveFunction recursiveFunction = new RecursiveFunction();
        recursiveFunction.solution(3);
    }
}
