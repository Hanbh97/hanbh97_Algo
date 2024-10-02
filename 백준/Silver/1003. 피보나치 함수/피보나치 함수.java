import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			
			// N번째 피보나치수
			N = Integer.parseInt(br.readLine());
			
			// 피보나치 메서드 실행
			fibonacci(N);
		}
		System.out.println(sb);
	}
	// 피보나치 메서드
	static void fibonacci(int n) {
		
		int a = 1;
		int b = 0;
		int c = 1;
		
		for(int i = 0; i < N; i++) {
			a = b;
			b = c;
			c = a + b;
		}
		
		sb.append(a).append(" ").append(b).append("\n");
	}
}
