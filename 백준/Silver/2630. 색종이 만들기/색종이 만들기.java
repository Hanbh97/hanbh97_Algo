import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static int w, b;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 판의 크기
		N = Integer.parseInt(br.readLine());
		
		// 판의 크기를 갖는 2차원 배열 선언 및 초기화
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 색의 개수 초기화
		w = 0;
		b = 0;
		
		// 메서드 실행
		divide(0, 0, N);
		
		sb.append(w).append("\n").append(b);
		System.out.println(sb);
	}	
	
	// 종이를 쪼개가면서 확인할 메서드
	static void divide(int r, int c, int size) {
		
		// 해당 영역이 모두 같은 색이면 개수를 셈
		if(check(r, c, size)) {
			
			// 해당 칸의 수를 +1
			if(board[r][c] == 1) {
				b++;
			}else {
				w++;
			}
		}
		
		// 아니라면 영역을 나눔
		else {
			
			// 크기를 반으로 나누고 4분면으로 재귀
			int half = size / 2;
			
			divide(r, c, half);
			divide(r, c + half, half);
			divide(r + half, c, half);
			divide(r + half, c + half, half);
		}
	}
	
	// 해당 구역의 색이 같은지 확인할 메서드
	static boolean check(int r, int c, int size) {
		
		// 시작 수를 저장
		int temp = board[r][c];
		
		// size 크기의 정사각형 만큼 배열을 순회
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				
				// 다르다면
				if(temp != board[i][j]) {
					return false;
				}
				
			}
		}
		
		// 모두 같다면
		return true;
	}
}
