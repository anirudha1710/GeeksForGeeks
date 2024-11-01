//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<int[]> q = new LinkedList<int[]>();
        int visited[] = new int[adj.size()];
        for (int i=0; i<visited.length; i++) {
            if (visited[i] == 1) { 
                continue;
            }
            int[] curr_prev_node = {i, -1};
            q.offer(curr_prev_node);
            while (!q.isEmpty()) {
                curr_prev_node = q.poll();
                visited[curr_prev_node[0]] = 1;
                for (int j=0; j< adj.get(curr_prev_node[0]).size(); j++) {
                    if (visited[adj.get(curr_prev_node[0]).get(j)] == 1 && adj.get(curr_prev_node[0]).get(j) != curr_prev_node[1]) {
                        return true;
                    }
                    if (visited[adj.get(curr_prev_node[0]).get(j)] == 0) {
                        int[] curr_prev_node_new = {adj.get(curr_prev_node[0]).get(j), curr_prev_node[0]};
                        q.offer(curr_prev_node_new);
                    }
                }
            }
        }
        return false;
    }
}