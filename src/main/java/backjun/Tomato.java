package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Tomato {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] box, dis;
    static int N, M;
    static Queue<Point> Q = new LinkedList<>();

    public void solution() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Tomato t = new Tomato();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        M = data[0];
        N = data[1];

        box = new int[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(temp[j]);
                if (box[i][j] == 1) {
                    Q.offer(new Point(i, j));
                }
            }
        }
        t.solution();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}
