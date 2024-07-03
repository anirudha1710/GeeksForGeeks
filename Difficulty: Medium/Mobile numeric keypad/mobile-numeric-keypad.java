//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        
        if(n==1)    return 10;
        long prev[] = new long[10], cur[] = new long[10], ans=0;
        Arrays.fill(prev,1);
        
        for(int j=2;j<=n;j++){
            
            for(int i=0;i<=9;i++){
            
                long temp=0;
                int id[] = findId(i);
                for(int d[]:dir){
                    int ni = id[0]+d[0], nj = id[1]+d[1];

                    if(valid(ni,nj)){
                        int nbr = dial[ni][nj];
                        
                        temp+=prev[nbr];
                    }
                }
                cur[i] = temp;
            }
            
            prev = cur;
            cur = new long[10];
        }
        
        for(long i:prev) ans+=i;
        
        return ans;
    }

    int[] findId(int no){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(dial[i][j]==no)  return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    
    boolean valid(int i,int j){
        if(i<0 || i>=4 || j<0 || j>=3 || dial[i][j]==-1)    return false;
        return true;
    }
    
    int dial[][] = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
    int dir[][] = {{0,0},{0,-1},{0,1},{1,0},{-1,0}};
}