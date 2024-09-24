import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K, N;
	static long[] lens;
	static long result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기 랜선 개수
		K = Integer.parseInt(st.nextToken());
		
		// 만들 랜선 개수
		N = Integer.parseInt(st.nextToken());
		
		// 랜선 길이를 담을 배열 선언
		lens = new long[K];
		
		// 배열을 초기화하면서 가장 긴 초기 길이 추출
		long maxlength = 0;
		for(int i = 0; i < K; i++) {
			lens[i] = Long.parseLong(br.readLine());
			if(lens[i] >= maxlength) maxlength = lens[i];
		}
		
		// 메서드 실행
		search(1, maxlength);
		
		System.out.println(result);
	}
	
	// N개 만들 수 있는 최대 길이를 찾는 메서드
	// 이진탐색 활용
	// 길이 범위는 1부터 maxlength까지
	static void search(long left, long right) {
		
		// 왼쪽 끝이 오른쪽 끝보다 클 때 종료 (길이를 찾았다는 의미)
        while(left <= right) { 
        	
        	// 오버플로우 방지
            long mid = (right + left) / 2;
            
            // 랜선 인덱스를 통해 중간값을 기준으로 만들어질 수 있는 개수를 카운팅
            int cnt = 0;
            
            for(int i = 0; i < K; i++) {
                cnt += lens[i] / mid;
            }
            
            // 개수가 더 많으면 크기를 더 크게
            if(cnt >= N) {
                result = mid;  // 현재의 길이가 가능하므로 저장
                left = mid + 1;  // 더 긴 길이를 탐색
            } 
            // 개수가 더 적다면 크기를 더 작게
            else {
                right = mid - 1;
            }
        }
	}
}