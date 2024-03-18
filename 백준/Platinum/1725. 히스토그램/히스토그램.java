import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n =  Integer.parseInt(in.readLine());
		int[] arr = new int[n+2];
		for(int i=1; i<n+1; ++i) 
			arr[i] = Integer.parseInt(in.readLine());
		
		
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int ans =0;
		for(int i=1; i<n+2; ++i) {
			while(!s.isEmpty()) {
				int top = s.peek();
				if(arr[top] <= arr[i]) break;
				s.pop();
				ans = Math.max(ans, arr[top]*(i-s.peek()-1));
			}
			s.push(i);
		}
		System.out.println(ans);
	}
}