package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KevinBacon {
    static int N, M;
    static int INF = 1000000000;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        // 그래프 초기화
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        // 입력 정보로 그래프 업데이트
        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 플로이드-와샬 알고리즘을 사용하여 모든 쌍 최단 경로 계산
        // k:중간점 i:시작점 j:끝점
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int minBacon = INF;
        int result = 0;

        // 각 사용자(노드)에 대한 베이컨 수 계산
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += graph[i][j];
            }
            if (sum < minBacon) {
                minBacon = sum;
                result = i;
            }
        }
        System.out.println(result);
    }
}
