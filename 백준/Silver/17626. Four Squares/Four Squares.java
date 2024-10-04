import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 확인할 자연수
		int n = Integer.parseInt(br.readLine());
		
		// 사용할 dp배열을 선언
		int[] dp = new int[n + 1];
		
		// n을 넘지않는 제곱수들을 담은 list를 선언 및 초기화
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i * i <= n; i++) {
			list.add(i * i);
		}
		
		// 작업전, 초기 dp배열을 초기화
		for(int i = 1; i <= n; i++) {
			
			// 최솟값을 구하기위해 배열을 모두 최댓값으로 저장
			if(dp[i] == 0) {
				dp[i] = Integer.MAX_VALUE;				
			}
		}
		
		// 점화식을 기준으로 dp배열을 초기화
		for(int i = 0; i < list.size(); i++) {
			
			// 제곱수를 임시 변수에 담음
			int temp = list.get(i);
			
			for(int j = temp; j <= n; j++) {
				dp[j] = Math.min(dp[j], dp[j - temp] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}