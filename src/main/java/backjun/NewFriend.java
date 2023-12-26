package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewFriend {

    // 이차원 배열 탐색을 위한 dx, dy 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;

    // 탐색 배열
    static char[][] arr;
    // 방문 여부 확인
    static boolean[][] check;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        arr = new char[n][m];
        check = new boolean[n][m];

        int doyeonX = 0;
        int doyeonY = 0;

        for (int i = 0; i < arr.length; i++) {
            char[] data = br.readLine().toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                // 시작 위치 저장
                if (data[j] == 'I') {
                    doyeonX = i;
                    doyeonY = j;
                }
                // 탐색 배열 저장
                arr[i][j] = data[j];
            }
        }

        findBuddy(doyeonX, doyeonY);

        if (cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }
    }

    private static void findBuddy(int x, int y) {
        check[x][y] = true;
        if (arr[x][y] == 'P') {
            cnt++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isValid(nx, ny) && !check[nx][ny] && arr[nx][ny] != 'X') {
                findBuddy(nx, ny);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
