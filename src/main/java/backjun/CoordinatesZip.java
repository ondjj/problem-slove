package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class CoordinatesZip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }
        HashMap<Integer, Integer> hash = coordinateZip(arr);

        for (int key : arr) {
            int rank = hash.get(key);
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }

    private static HashMap<Integer, Integer> coordinateZip(final int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        Arrays.sort(copy);

        HashMap<Integer, Integer> map = new HashMap<>();
        int value = 0;

        for (int j : copy) {
            if (!map.containsKey(j)) {
                map.put(j, value);
                value++;
            }
        }
        return map;
    }
}
