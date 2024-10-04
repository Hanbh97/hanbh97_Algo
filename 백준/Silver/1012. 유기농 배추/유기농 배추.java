import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {		
	
	static int M, N, K;
	static int[][] land;
	static boolean[][] check;
	
	// 주변을 확인할 델타 배열을 선언
	//                 상  우  하  좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트케이스 수 
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			
			// 밭의 가로 길이 M, 세로길이 N, 배추의 개수 K
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 밭 2차원 배열을 선언 및 초기화
			land = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				land[b][a] = 1;
			}
			
			// 방문 2차원 배열을 선언
			check = new boolean[N][M];
			
			// 결과 변수 선언
			int result = 0;
			
			// 밭 전체를 탐색
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					
					// 배추가 있다면 연결되어있는지 탐색 시작
					// 탐색이 종료되면 한 덩어리를 모두 탐색했다는 뜻
					// 결과를 +1
					if(land[i][j] == 1 && !check[i][j]) {	
						dfs(i, j);		
						result++;
					}
					
				}
			}
			System.out.println(result);
		}
		
	}
	
	// dfs 메서드
	static void dfs(int i, int j) {		
		
		// 현재 지점을 방문 체크
		check[i][j] = true;

		// 다음 지점을 가리킬 변수 선언
		int nr = i;
		int nc = j;
		
		// 델타를 순회
		for(int dir = 0; dir < 4; dir++) {
			
			// 델타로 이동한 위치
			nr += dr[dir];
			nc += dc[dir];
			
			// 배열의 크기를 넘지 않고
			// 방문하지 않았으면서 1인 경우
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && !check[nr][nc] && land[nr][nc] == 1) {
				
				// 재귀 진행
				dfs(nr, nc);
              	nr = i;
				nc = j;
			}
			
			// 해당사항이 없다면 델타를 순회
			else {
				nr = i;
				nc = j;
			}
		}
	}
}
