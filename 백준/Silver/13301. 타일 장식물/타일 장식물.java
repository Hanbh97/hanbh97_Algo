import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 타일의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 타일 개수 만큼의 dp 배열을 선언
		long[] dp = new long[N + 1];
		
		// dp를 초기화
		for(int i = 0; i <= N; i++) {
			
			// 우선 시작 길이를 초기화
			if(i == 1 || i == 0) {
				dp[i] = 1;
			}
			
			// 이후 점화식에 따라 dp를 초기화
			else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		
		// 둘레의 길이를 계산
		long result = (dp[N] + dp[N - 1]) * 2;

		System.out.println(result);
	}
}
