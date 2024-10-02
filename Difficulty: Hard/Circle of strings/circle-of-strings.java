//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        // code here
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        
        
        for (String str : arr) {
            int firstChar = str.charAt(0) - 'a';
            int lastChar = str.charAt(str.length() - 1) - 'a';
            outDegree[firstChar]++;
            inDegree[lastChar]++;
            graph.get(firstChar).add(lastChar);
        }
        
        
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;  
            }
        }
        
       
        int startNode = -1;
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                startNode = i;
                break;
            }
        }
        
        if (startNode == -1) {
            return 1;  
        }
        
        
        boolean[] visited = new boolean[26];
        dfs(startNode, graph, visited);
        
        
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return 0;  
            }
        }
        
        return 1; 
    }
    
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}