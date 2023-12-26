package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp != 0) {
                priQueue.add(temp);
            } else if (priQueue.isEmpty()) {
                System.out.println(0);
            }else {
                System.out.println(priQueue.poll());
            }
        }
    }
}
