import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int cnt;
	static char[][] campus;
	static boolean[][] check;
	
	// 델타 배열을 선언
	//                 상  우  하  좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 캠퍼스의 세로길이 N, 가로길이 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 시작 지점을 담을 변수
		int r = 0;
		int c = 0;
		
		// 만난 사람 수
		cnt = 0;
		
		// 캠퍼스 2차원배열을 선언 및 초기화
		campus = new char[N][M];
		for(int i = 0 ; i < N; i++) {
			
			// 한 줄을 입력받음
			String line = br.readLine();			
			for(int j = 0; j < M; j++) {
				campus[i][j] = line.charAt(j);
				
				// 해당 문자가 I일 경우 시작지점에 담음
				if(line.charAt(j) == 'I') {
					r = i;
					c = j;
				}
			}
		}
		
		// 캠퍼스 크기의 방문 배열을 선언
		check = new boolean[N][M];
		
		// dfs 실행
		dfs(r, c);
		
		// 아무도 못 만났다면 TT
		if(cnt == 0) sb.append("TT");
		else sb.append(cnt);
		
		System.out.println(sb);
	}
	
	// dfs를 진행하는 메서드
	static void dfs(int r, int c) {
		
		// 현재 위치를 방문체크
		check[r][c] = true;		
		
		// 반복문을 통해 델타배열을 순회
		for(int i = 0; i < 4; i++) {			
			
			// 다음으로 이동할 위치 변수
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 배열을 벗어나지 않게 우선 조건
			if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
				
				// 다음 이동할 위치가 다음을 만족하면 이동
				// 1. 아직방문하지 않았고
				// 2. X가 아닐 경우
				if(!check[nr][nc] && campus[nr][nc] != 'X') {

					// 해당 지점에 사람이 있다면 카운팅
					if(campus[nr][nc] == 'P') cnt++;
					dfs(nr, nc);					
				}
				
				// 하나라도 만족하지 않으면 위치를 처음으로 초기화하고 다음 델타로 이동
				else {
					nr = r;
					nc = c;
				}
			}
			
			// 배열을 벗어나도 초기화
			else {
				nr = r;
				nc = c;
			}
		}
	}
}