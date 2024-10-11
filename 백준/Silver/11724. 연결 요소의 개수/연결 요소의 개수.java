import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] adj;
	static boolean[] check;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점의 개수 N, 간선의 개수 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 인접 행렬을 선언
		adj = new int[N + 1][N + 1];
		
		// 입력되는 연결관계를 적용
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 연결될 두 정점
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 무향이므로 대칭으로 1로 저장
			adj[a][b] = adj[b][a] = 1;
		}
		
		// 방문 배열을 선언
		check = new boolean[N + 1];
		
		// 결과 변수 초기화
		cnt = 0;
		
		// 정점을 순회하면서 연결 요소를 카운팅
		for(int i = 1; i <= N; i++) {
			
			// 시작점이 false일때만 진행
			if(!check[i]) {
				dfs(i);

				// 해당 지점 완료후 카운팅
				cnt++;
			}	
		}
		System.out.println(cnt);
	}
	
	// dfs를 진행할 메서드
	static void dfs(int start) {
		
		// 현재 지점을 방문체크
		check[start] = true;
		
		// 배열을 순회
		for(int i = 1; i <= N; i++) {
			
			// 아직 방문하지 않았고 연결되어있다면 재귀
			if(!check[i] && adj[start][i] == 1) {
				dfs(i);
			}
		}
	}
}
