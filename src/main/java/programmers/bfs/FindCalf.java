package programmers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindCalf {
    int[] dis = {1, -1, 5};
    int[] visited;
    Queue<Integer> queue = new LinkedList<>();

    public int solution(int node, int target) {
        visited[node] = 1;
        queue.offer(node);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == target) return level + 1;
                    if (nx >= 1 && nx <= 10000 && visited[nx] == 0) {
                        visited[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        FindCalf findCalf = new FindCalf();
        System.out.println(findCalf.solution(5, 14));
    }
}
