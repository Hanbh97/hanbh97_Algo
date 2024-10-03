import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 계단의 수
		int h = Integer.parseInt(br.readLine());
		
		// 계단의 점수를 담을 배열
		// h까지이므로 크기는 +1
		int[] point = new int[h + 1];
		for(int i = 1; i <= h; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		
		// dp배열을 선언
		int[] dp = new int[h + 1];
		
		// i만큼 나누어 dp의 점화식을 적용
		for(int i = 1; i <= h; i++) {
			
			// 2칸까지는 모두 더해도 가능
			if(i <= 2) {
				dp[i] = dp[i - 1] + point[i];
			}
			
			// 3칸 이상일때는 점화식 사용
			else{
				dp[i] = Math.max(point[i - 1] + dp[i - 3]
						, dp[i -2]) + point[i];
			}
		}
		System.out.println(dp[h]);
	}
}