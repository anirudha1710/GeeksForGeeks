//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {
        // code is here
        if (n <= 2) return 0;

        int leftarr[] = new int[n];
        int rightarr[] = new int[n];

        leftarr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftarr[i] = Math.max(arr[i], leftarr[i - 1]);
        }
        rightarr[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightarr[j] = Math.max(arr[j], rightarr[j + 1]);
        }

        long trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftarr[i], rightarr[i]) - arr[i];
        }

        return trappedWater;
    }
}