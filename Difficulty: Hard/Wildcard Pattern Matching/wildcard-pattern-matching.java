//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        // code here
        Boolean dp[][]=new  Boolean[str.length()][pattern.length()];
        if(helper(str,pattern,str.length()-1, pattern.length()-1,dp)) return 1;
        return 0;
    }
    public static boolean helper(String str, String pat, int i, int j, Boolean dp[][]){
        if(i < 0 && j < 0) return true;  
        if(j < 0) return false;          
        if(i < 0) {                      
            for(int k = 0; k <= j; k++) {
                if(pat.charAt(k) != '*') return false;
            }
            return true;
        }

        
        if(dp[i][j] != null) return dp[i][j];

        if(str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?') {
            dp[i][j] = helper(str, pat, i - 1, j - 1, dp);
        } else if(pat.charAt(j) == '*') {
            dp[i][j] = helper(str, pat, i - 1, j, dp) || helper(str, pat, i, j - 1, dp);
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
    
}
