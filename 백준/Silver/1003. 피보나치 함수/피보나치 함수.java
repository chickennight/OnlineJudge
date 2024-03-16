import java.io.*;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static Integer[][] arr = new Integer[41][2];

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		while(T-- >0) {
			int N = Integer.parseInt(in.readLine());
			arr[0][0] = 1;
            arr[0][1] = 0;
            arr[1][0] = 0;
            arr[1][1] = 1;
            
			fibonacci(N);
			sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
		}
		
		System.out.println(sb);
	}
 
	public static Integer[] fibonacci(int n) {
		if (arr[n][0] == null || arr[n][1] == null) {

            arr[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            arr[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];

        }

        return arr[n];
	}

}