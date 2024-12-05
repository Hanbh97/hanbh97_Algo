import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int place;
    static int[][] map;
    static boolean[][] check;
    static int cnt;

    // 각 단지의 가구 수를 넣을 리스트 선언
    static List<Integer> q = new ArrayList<>();

    // 델타 배열 상 우 하 좌
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();

	// 지도의 크기 N
	N = Integer.parseInt(br.readLine());

	// 지도 배열을 초기화
	map = new int[N][N];

	for (int i = 0; i < N; i++) {

	    String line = br.readLine();

	    for (int j = 0; j < N; j++) {
		map[i][j] = line.charAt(j) - '0';
	    }
	}

	// 방문 배열을 선언
	check = new boolean[N][N];

	// 단지 개수
	place = 0;

	// 지도를 순회
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {

		// 가구가 존재하고 아직 방문하지 않았다면 탐색시작
		// 탐색 후 단지 수 +1
		if (map[i][j] == 1 && !check[i][j]) {

		    // 가구 수 초기화
		    cnt = 0;

		    // 메서드 실행
		    dfs(i, j);
		    place++;

		    // 리스트에 가구 수 저장
		    q.add(cnt);
		}
	    }
	}

	Collections.sort(q);

	sb.append(place).append("\n");

	if (q.isEmpty()) {
	    sb.append(0);
	} else {
	    for (int num : q) {
		sb.append(num).append("\n");
	    }
	}

	System.out.println(sb);
    }

    // dfs 메서드
    static void dfs(int r, int c) {

	// 시작 지점을 방문 체크
	check[r][c] = true;

	// 가구 수 +1
	cnt++;

	// 델타 순회
	for (int i = 0; i < 4; i++) {

	    // 이동하려는 위치
	    int nr = r + dr[i];
	    int nc = c + dc[i];

	    // 범위를 벗어나지 않고
	    // 가구가 존재하며
	    // 아직 방문하지 않은 곳이면 재귀
	    if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !check[nr][nc]) {
		dfs(nr, nc);
	    }
	}
    }
}