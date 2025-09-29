
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Check if u and v are already connected in current graph
            boolean[] visited = new boolean[n + 1];
            if (isConnected(graph, u, v, visited)) {
                return edge; // this edge forms a cycle
            }

            // Otherwise add edge to graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }

    private boolean isConnected(List<List<Integer>> graph, int src, int dest, boolean[] visited) {
        if (src == dest) return true;
        visited[src] = true;
        for (int nei : graph.get(src)) {
            if (!visited[nei] && isConnected(graph, nei, dest, visited)) {
                return true;
            }
        }
        return false;
    }
}
