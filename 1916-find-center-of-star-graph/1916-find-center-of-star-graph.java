class Solution {

    ArrayList<Integer>[] adj;
    int[] vis;

    void traversal(int i) {
        for (int a : adj[i]) {
            vis[i]++;
        }
    }

    public int findCenter(int[][] edges) {

        int n = edges.length + 1;

        adj = new ArrayList[n+1];
        vis = new int[n+1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 0; i <= n; i++) {
            traversal(i);
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i] == n-1) return i;
        }

        return -1;

    }
}