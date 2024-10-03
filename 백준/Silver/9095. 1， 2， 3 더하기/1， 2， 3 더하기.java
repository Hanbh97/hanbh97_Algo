import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			
			// 알아볼 수를 입력
			int N = Integer.parseInt(br.readLine());
			
			// 사용할 dp배열을 선언
			int[] dp = new int[N + 1];
			
			// 0은 1로 초기화
			dp[0] = 1;
			
			// 반복문으로 dp 초기화
			// 점화식을 따른다
			for(int i = 1; i <= N; i++) {
				
				// i가 1이라면
				if(i == 1) {
					dp[i] = dp[i - 1];
				}
				
				// i가 2이하라면
				else if(i <= 2) {
					dp[i] = dp[i - 1] + dp[i - 2];
				}
				
				// i가 3이상이라면
				else if(i >= 3) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				}
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}