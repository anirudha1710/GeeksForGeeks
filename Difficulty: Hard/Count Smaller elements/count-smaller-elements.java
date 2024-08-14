//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] constructLowerArray(int[] arr) {
        // code here
        int n=arr.length;
        
        int [][] a=new int [n][3];
        
        for(int i=0;i<n;i++)
        {
            a[i][0]=arr[i];
            a[i][1]=i;
        }
        
        int ans[][]=merge(0,n-1,a);
        
        int [] answer=new int [n];
        
        for(int i=0;i<n;i++)
        answer[ans[i][1]]=ans[i][2];
        
        return answer;
    }
    int [][] merge(int st,int ed,int a[][])
    {
          int [][] n=new int [1][3];
           if(st==ed)
           {
               n[0][0]=a[st][0];
               n[0][1]=a[st][1];
               n[0][2]=a[st][2];
           return n;
           }
           
           int mid=st+(ed-st)/2;
           
           int a1[][]=merge(st,mid,a);
           int a2[][]=merge(mid+1,ed,a);
           
           
           int [][] ans=new int [ed-st+1][3];
           
           int i=0,s1=0,s2=0,e1=mid-st+1,e2=ed-mid,c=0;
           
           for(i=0;i<ed-st+1;i++)
           {
                 if(s1>=e1)
                 {
                     ans[i][0]=a2[s2][0];
                     ans[i][1]=a2[s2][1];
                     ans[i][2]=a2[s2][2];
                     s2++;
                 }
                 else if(s2>=e2)
                 {
                     ans[i][0]=a1[s1][0];
                     ans[i][1]=a1[s1][1];
                     ans[i][2]=a1[s1][2]+c;
                     s1++;
                 }
                 else if(a1[s1][0]>a2[s2][0])
                 {
                       c++;
                       ans[i][0]=a2[s2][0];
                       ans[i][1]=a2[s2][1];
                       ans[i][2]=a2[s2][2];
                       s2++;
                 }
                 else
                 {
                      ans[i][0]=a1[s1][0];
                     ans[i][1]=a1[s1][1];
                     ans[i][2]=a1[s1][2]+c;
                     s1++;
                 }
           }
           
           return ans;
    }
}