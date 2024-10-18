import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, B;
	static int low, high;
	static int[][] land;
	static int get, set;
	static int time, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 세로 N, 가로 M, 인벤토리 블록 B
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		// 구역에서 가장 낮은 높이와 가장 높은 높이 변수
		low = Integer.MAX_VALUE;
		high = Integer.MIN_VALUE;
		
		// 구역의 높이를 2차원 배열에 할당
		land = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for(int c = 0; c < M; c++) {
				land[r][c] = Integer.parseInt(st.nextToken());
				
				// 최고 높이와 최저 높이를 계산
				if(land[r][c] <= low) low = land[r][c];
				if(land[r][c] >= high) high = land[r][c];
			}
		}
		
		// 걸리는 시간, 적절한 높이 변수
		time = Integer.MAX_VALUE;
		result = 0;

		for(int i = low; i <= high; i++) {
			
			int temp = time(i);
			
			// 가장 적은 시간일 때의 시간과 높이를 저장
			if(time >= temp){
				time = temp;
				result = i;					
			}	
		}

		sb.append(time).append(" ").append(result);
		System.out.println(sb);
	}
	
	// 걸리는 시간을 계산할 메서드
	static int time(int hight) {
		
		// 변수 초기화
		get = 0;
		set = 0;
		
		// 배열을 순회
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
						
				// hight보다 높으면 인벤토리에 저장
				if(land[r][c] > hight) {
					get += land[r][c] - hight;
				}
						
				// 낮으면 설치
				else if(land[r][c] < hight){
					set += hight - land[r][c];
				}
			}
		}
		
		// 인벤토리의 양으로 설치가 가능한지 판단
		if(set <= get + B) {
			return get * 2 + set;
		}
		
		else {
			return Integer.MAX_VALUE;
		}
	}
}