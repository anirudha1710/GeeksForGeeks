//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        Set<String> map=new HashSet<>();
        for(String s:arr){
            String rev=rev(s).toString();
            if(map.contains(rev)) map.remove(rev);
            else map.add(s);
        }
        if(map.size()==0) return true;
        if(map.size()>1) return false;
        String s="";
        for(String key:map) s=key;
        return isPal(s);
    }
    static boolean isPal(String s){
        int lo=0,hi=s.length()-1;
        while(lo<hi){
            if(s.charAt(lo++)!=s.charAt(hi--)) return false;
        }
        return true;
    }
    static StringBuilder rev(String s){
        StringBuilder ans=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--) ans.append(s.charAt(i));
        return ans;
    }
}
        
