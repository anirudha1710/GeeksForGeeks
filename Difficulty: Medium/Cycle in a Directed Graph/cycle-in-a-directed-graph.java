//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visited, int[] currPath, int curr){
        visited[curr] = 1;
        currPath[curr] = 1;
        
        for( int i : adj.get(curr) ){
            if(visited[i] == 0){
                boolean ans = dfs(adj, visited, currPath, i);
                if(ans) return true;
            }
            else if( currPath[i] == 1){
                return true;
            }
            
        }
        currPath[curr] = 0;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new  int[V];
        int[] currPath = new int[V];
        
        for( int i =0; i<V ;i++){
            if( visited[i] == 0){
                boolean ans = dfs(adj, visited, currPath, i);
                if(ans == true) return true;
            }
        }
        
        return false;
    }
}