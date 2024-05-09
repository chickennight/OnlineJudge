class Solution {
    private int[] infos;
    private int[][] edgeList;
    private int max;

    public int solution(int[] info, int[][] edges) {
        infos = info;
        edgeList = edges;
        max = 0;
        boolean[] startVisited = new boolean[info.length];
        dfs(0, startVisited, 0, 0);

        return max;
    }

    private void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true;
        if (infos[idx] == 0) {
            sheepCnt++;
            if (sheepCnt > max) {
                max = sheepCnt;
            }
        } else {
            wolfCnt++;
        }

        if (sheepCnt <= wolfCnt) {
            return;
        }

        for (int[] edge : edgeList) {
            if (visited[edge[0]] && !visited[edge[1]]) {
            	boolean[] nextVisited = new boolean[visited.length];
            	for (int i = 0; i < visited.length; ++i) {
                	nextVisited[i] = visited[i];
            	}
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
            }
        }
    }
}