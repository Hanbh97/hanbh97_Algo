import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 직사각형의 크기
		int n = Integer.parseInt(br.readLine());
		
		// dp배열을 선언
		int[] dp = new int[n + 1];
		
		// 점화식에 따라 dp를 초기화
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			
			// 짝수일 경우
			if(i % 2 == 0) {
				dp[i] = (dp[i - 1] * 2 + 1) % 10007;
			}
			
			// 홀수일 경우
			else {
				dp[i] = (dp[i - 1] * 2 - 1) % 10007;
			}
		}
		System.out.println(dp[n]);
	}	
}