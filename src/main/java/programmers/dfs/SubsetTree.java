package programmers.dfs;


public class SubsetTree {
    private static int n;
    private static int[] selectNode;

    public void solution(int level) {
        if (level == n + 1) {
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < selectNode.length; i++) {
                if (selectNode[i] == 1) {
                    temp.append(i).append(" ");
                }
            }
            if (temp.length() > 0) {
                System.out.println(temp);
            }
            return;
        }
        selectNode[level] = 1;
        solution(level + 1);
        selectNode[level] = 0;
        solution(level + 1);
    }

    public static void main(String[] args) {
        SubsetTree subsetTree = new SubsetTree();
        n = 3;
        selectNode = new int[n + 1];
        subsetTree.solution(1);
    }
}
