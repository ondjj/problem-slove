package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int begin;
        int end;

        Meeting(int b, int e) {
            this.begin = b;
            this.end = e;
        }

        @Override
        public int compareTo(final Meeting m) {
            if (this.end == m.end) return this.begin - m.begin;
            else return this.end - m.end;
        }
    }

    public int solution(ArrayList<Meeting> arr, int n) {
        Collections.sort(arr);
        int cnt = 0;
        int et = 0;
        for (Meeting mt : arr){
            if (mt.begin >= et){
                cnt++;
                et = mt.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int b = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            Meeting any = new Meeting(b, e);
            arr.add(any);
        }

        System.out.println(t.solution(arr, n));
        br.close();
    }
}
