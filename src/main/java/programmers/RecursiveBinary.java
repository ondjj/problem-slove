package programmers;

public class RecursiveBinary {
    public void solution(int a) {
        if (a <= 0) {
            return;
        }
        solution(a / 2);
        System.out.print(a % 2 + "\t");
    }

    public static void main(String[] args) {
        RecursiveBinary recursiveBinary = new RecursiveBinary();
        recursiveBinary.solution(11);
    }
}
