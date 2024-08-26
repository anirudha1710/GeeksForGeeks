//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);
                
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // Code here
        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            bSet.add(B[i]);
        }

    
        List<Integer> filteredA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (bSet.contains(A[i])) {
                filteredA.add(A[i]);
            }
        }

        List<Integer> lis = new ArrayList<>();
        for (int num : filteredA) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx < lis.size()) {
                lis.set(idx, num);
            } else {
                lis.add(num);
            }
        }
        int lcsLength = lis.size();

        int deletions = N - lcsLength;
        int insertions = M - lcsLength;
        return deletions + insertions;
    }
};