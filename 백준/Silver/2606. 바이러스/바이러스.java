import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	
	static int N, M, result;
	static int[][] adj;
	static boolean[] check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 컴퓨터의 수 (정점)
		N = Integer.parseInt(br.readLine());
		
		// 연결된 컴퓨터 쌍 수 (간선)
		M = Integer.parseInt(br.readLine());
		
		// 인접행렬을 선언
		// 0을 제외한 N까지 이므로 +1
		adj = new int[N + 1][N + 1];
		
		// 연결 관계를 입력
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 무향이므로 대칭적으로 1로 변환
			adj[a][b] = adj[b][a] = 1;
		}
		
		// 방문 배열을 선언
		check = new boolean[N + 1];
		
		// 감염된 컴퓨터 수
		result = 0;
		
		// 시작점은 1번 컴퓨터
		dfs(1);
		
		// 1번을 제외하고 감염된 컴퓨터 수 이므로 -1
		System.out.println(result - 1);
	}
	
	// dfs를 진행하기위한 메서드
	static void dfs(int v) {
		
		// 현재 지점을 방문으로 변경
		check[v] = true;
		result++;
		
		// 모든 컴퓨터를 돌면서 확인
		for(int i = 1; i <= N; i++) {
			
			// 다음 컴퓨터가 아직 방문 하지 않았고
			// 서로 연결되어있다면
			if(!check[i] && adj[v][i] == 1) {
				
				// 그 컴퓨터로 재귀 진행
				dfs(i);
			}
		}
	}
}