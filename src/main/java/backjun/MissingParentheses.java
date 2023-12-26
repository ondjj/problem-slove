package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingParentheses {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        String[] subtractedParts = expression.split("-");
        int result = 0;

        for (int i = 0; i < subtractedParts.length; i++) {
            String[] addedParts = subtractedParts[i].split("\\+");
            int sum = 0;
            for (String part : addedParts) {
                sum += Integer.parseInt(part);
            }
            if (i == 0) {
                result += sum; // 첫 번째 부분은 더하기
            } else {
                result -= sum; // 나머지 부분은 빼기
            }
        }

        System.out.println(result);
        br.close();
    }
}
