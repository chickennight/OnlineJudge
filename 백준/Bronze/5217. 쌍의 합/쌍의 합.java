import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < T; ++i) {
			int n = Integer.parseInt(in.readLine());
			String S = "Pairs for " + n + ": ";
			
			for(int j = 1; j <= n / 2; ++j) {
				
				if(j != (n - j)) {
					if(j > 1) 
						S += ", ";
					S += j + " " + (n - j);
				}
			}
			System.out.println(S);
		}
	}

}
