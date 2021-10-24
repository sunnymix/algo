package week03.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode: https://leetcode-cn.com/problems/redundant-connection/
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        this.edges = edges;
        n = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }
        toEdges = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            toEdges.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            toEdges.get(x).add(y);
            toEdges.get(y).add(x);
            hasCycle = false;
            for (int i = 1; i <= n; i++) {
                visited[i] = false;
            }
            _dfs(x, 0);
            if (hasCycle) {
                return edge;
            }
        }
        return new int[]{};
    }

    int n;
    int[][] edges;
    List<List<Integer>> toEdges;
    boolean[] visited;
    boolean hasCycle;

    private void _dfs(int x, int father) {
        visited[x] = true;
        for (int y : toEdges.get(x)) {
            if (y == father) {
                continue;
            }
            if (!visited[y]) {
                _dfs(y, x);
            } else {
                hasCycle = true;
            }
        }
    }
}
