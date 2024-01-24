//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static boolean dfs(ArrayList<Integer>[] adj,Stack<Integer> s,int v,int[] vis,int[] pathVis){
        vis[v]=1;
        pathVis[v]=1;
        for(int x: adj[v]){
            if(vis[x]==0){
                if(dfs(adj,s,x,vis,pathVis)==false){
                    return false;
                }
                
            }
            else if(vis[x]==1){
               if(pathVis[x]==1){
                   return false;
               }
            }
        }
        pathVis[v]=0;
        s.push(v);
        return true;
    }
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> p) 
    {
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]= new ArrayList<>();
        }
        for(int i=0;i<p.size();i++){
           
            adj[p.get(i).get(1)].add(p.get(i).get(0));
        }
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(dfs(adj,s,i,vis,pathVis)==false){
                    int[] arr={};
            return arr;
                }
            }
        }
        if(s.size()<n){
           int[] arr={};
            return arr;
                }
        else{
            int i=0;
            while(!s.isEmpty()){
                vis[i]=s.pop();
                i++;
            }
            return vis;
        }
    }
}