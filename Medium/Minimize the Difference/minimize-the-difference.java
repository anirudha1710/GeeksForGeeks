//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
        int ans = Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        int min1=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int max1=Integer.MIN_VALUE;
        int[] minl = new int[n];
        int[] minr = new int[n];
        int[] maxl = new int[n];
        int[] maxr = new int[n];
        for(int i=0,j=n-1;i<n;i++,j--){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
            min1 = Math.min(min1,arr[j]);
            max1 = Math.max(max1,arr[j]);
            minl[i]=min;
            maxl[i]=max;
            minr[j]=min1;
            maxr[j]=max1;
        }
        for(int i=0;i<=n-k;i++){
            if(i>0 && i<n-k){
                min = Math.min(minl[i-1],minr[i+k]);
                max = Math.max(maxl[i-1],maxr[i+k]);
                ans = Math.min(ans,Math.abs(max-min));
            }
            else if(i==0){
                ans = Math.min(ans,maxr[i+k]-minr[i+k]);
            }
            else{
                ans = Math.min(ans,maxl[i-1]-minl[i-1]);
            }
        }
        return ans;
    }
}
        
