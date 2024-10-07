import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, max, result;
	static int[] length;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 나무의 수 N, 원하는 길이 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 가장 긴 높이의 나무 변수
		max = 0;
		
		// 나무 길이를 담을 배열
		length = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			length[i] = Integer.parseInt(st.nextToken());
			
			// 가장 높은 나무를 저장
			max = Math.max(max, length[i]);
		}
		
		// 결과를 담을 변수
		result = 0;
		
		search(0, max);
		System.out.println(result);
	}
	
	// 이진 탐색 메서드
	static void search(int start, int end) {
		
		// 중간 지점을 선택
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			// 자른 윗부분의 길이를 담을 변수
			long cut = 0;
			for(int i = 0; i < N; i++) {
				
				// 자른 부분이 양수일 때만 더함
				if(length[i] > mid) {
					cut += length[i] - mid;
				}
			}
			
			// 원하는 길이보다 클 경우
			if(cut >= M) {
				result = mid;
				start = mid + 1;
			}
			
			// 작을 경우
			else {
				end = mid - 1;			
			}
		}
	}
}

