import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		// T만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			// 세 정수를 입력
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 정수 쌍의 개수 변수
			int cnt = 0;
			
			// 세 정수 범위에서 순회
			for(int i = 1; i <= a; i++) {
				for(int j = 1; j <= b; j++) {
					for(int k = 1; k <= c; k++) {
						
						// 계산 값이 같다면 cnt + 1
						if(i % j == j % k && j % k == k % i) {
							cnt++;
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
