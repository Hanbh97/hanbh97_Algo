import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시작 정수 
		int N = Integer.parseInt(br.readLine());
		
		// 연산 횟수 변수
		int cnt = 0;
		
		// 사용할 dp배열을 선언
		int[] dp = new int[N + 1];
		
		// 0은 볼필요가 없고, 1은 이미 0으로 초기화 되어있으므로
		// 2부터 시작
		// N까지 반복
		for(int i = 2; i <= N; i++) {
			
			// 3으로 나누어 떨어지면서 2로 나누어지면
			if(i % 3 == 0 && i % 2 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i / 2] + 1, dp[i - 1] + 1));
			}
			
			// 3으로만 나누어떨어지면
			else if(i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
			}
			
			// 2로 나누어 떨어지면
			else if(i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
			}
			
			// 모두 아니면 그냥 -1
			else {
				dp[i] = dp[i - 1] + 1;
			}
		}
		
		System.out.println(dp[N]);
	}	
}