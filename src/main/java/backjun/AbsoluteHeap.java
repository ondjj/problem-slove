package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(final Integer o1, final Integer o2) {
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);

        if (abs1 < abs2) {
            return -1;
        } else if (abs1 > abs2) {
            return 1;
        } else {
            return o1.compareTo(o2);
        }
    }
}

public class AbsoluteHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator());
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            if (m == 0){
                if (pq.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(pq.poll());
                }
            }else{
                pq.offer(m);
            }
        }
    }
}
