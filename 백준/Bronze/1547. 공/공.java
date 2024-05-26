import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int num = 1;
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int X =Integer.parseInt(st.nextToken());
			int Y =Integer.parseInt(st.nextToken());
			if(X == num) {
				num = Y;
			}else if(Y == num){
				num = X;
			}
		}
		
		System.out.println(num);
	}

}