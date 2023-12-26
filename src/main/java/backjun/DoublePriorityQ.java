package backjun;

import java.util.Comparator;
import java.util.PriorityQueue;


public class DoublePriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Comparator.reverseOrder());
    }
}
