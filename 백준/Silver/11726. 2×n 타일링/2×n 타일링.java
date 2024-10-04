import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 직사각형의 크기
		int n = Integer.parseInt(br.readLine());
		
		// dp배열을 선언
		long[] dp = new long[n + 1];
		
		// 점화식에 따라 dp를 초기화
		dp[0] = 1;
		for(int i = 1; i <= n; i++) {
			if(i == 1) {
				dp[i] = 1;
			}
			
			else {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}
		}
		System.out.println(dp[n]);
	}	
}
