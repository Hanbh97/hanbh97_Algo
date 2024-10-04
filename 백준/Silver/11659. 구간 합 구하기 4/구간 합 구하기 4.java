import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수의 개수 N, 합을 구하는 횟수 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 수들을 담은 배열을 선언 및 초기화
		int[] nums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		// 배열은 누적합 배열로 만든다
		for(int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			
			nums[i] = nums[i - 1] + temp;
		}

		// M만큼 반복 작업
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 시작 수 a, 끝 수 b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 주어진 범위만큼의 합은
			// 누적합 배열에서 (끝 인덱스) - (시작 인덱스 - 1)와 같다
			int result = nums[b] - nums[a - 1];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}	
}