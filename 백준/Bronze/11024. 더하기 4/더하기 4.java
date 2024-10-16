import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		// T만큼 반복
		for(int i = 0 ; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 한 줄의 합
			int sum = 0;
			
			// 한 줄의 st 현재 사이즈를 저장 
			int size = st.countTokens();
			
			for(int j = 0; j < size; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
