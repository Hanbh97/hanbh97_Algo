import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] check;

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	// 두 정수 N, M
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());

	// 해당 크기의 미로
	board = new int[N][M];

	// 방문 배열
	check = new int[N][M];

	// 미로 초기화
	for (int r = 0; r < N; r++) {

	    // 한 줄 입력
	    String line = br.readLine();

	    for (int c = 0; c < M; c++) {

		// 문자를 정수로 변환하기 위해 -48
		board[r][c] = line.charAt(c) - 48;
	    }
	}

	// 시작지점 1로 초기화
	check[0][0] = 1;

	// 0, 0에서 출발
	bfs(0, 0);

	System.out.println(check[N - 1][M - 1]);
    }

    // bfs 메서드
    static void bfs(int r, int c) {

	// 사용할 큐를 선언
	Queue<Integer> qr = new LinkedList<>();
	Queue<Integer> qc = new LinkedList<>();

	// 시작 지점 삽입
	qr.add(r);
	qc.add(c);

	// 델타 배열 상 우 하 좌
	int[] dr = { -1, 0, 1, 0 };
	int[] dc = { 0, 1, 0, -1 };

	while (!qr.isEmpty() && !qc.isEmpty()) {

	    // 너비 우선 탐색 하나 꺼내기
	    int n = qr.poll();
	    int m = qc.poll();

	    // 델타 배열만큼 순회
	    for (int i = 0; i < 4; i++) {

		// 이동할 위치
		int nr = n + dr[i];
		int nc = m + dc[i];

		// 미로를 벗어나지 않고
		// 0이 아니고
		// 방문하지 않은 곳이면 저장
		if (nr < N && nr >= 0 && nc < M && nc >= 0 && board[nr][nc] != 0 && check[nr][nc] == 0) {
		    qr.add(nr);
		    qc.add(nc);

		    // 한 칸 이동
		    check[nr][nc] = check[n][m] + 1;
		}
	    }
	}
	return;
    }
}