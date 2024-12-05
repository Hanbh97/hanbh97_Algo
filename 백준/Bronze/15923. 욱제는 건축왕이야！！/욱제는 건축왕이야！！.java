import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;

	// 꼭짓점의 개수
	int N = Integer.parseInt(br.readLine());

	// 둘레의 길이 변수
	int result = 0;

	// 시작 지점의 좌표
	st = new StringTokenizer(br.readLine());
	int x = Integer.parseInt(st.nextToken());
	int y = Integer.parseInt(st.nextToken());

	// 현재 좌표
	int dx = x;
	int dy = y;

	// 둘레의 길이 계산
	for (int i = 1; i < N; i++) {

	    // 다음 점의 좌표
	    st = new StringTokenizer(br.readLine());
	    int nx = Integer.parseInt(st.nextToken());
	    int ny = Integer.parseInt(st.nextToken());

	    // 좌표 차이 변수
	    int cx = 0;
	    int cy = 0;

	    if (nx >= dx) {
		cx = nx - dx;
	    } else {
		cx = dx - nx;
	    }

	    if (ny >= dy) {
		cy = ny - dy;
	    } else {
		cy = dy - ny;
	    }

	    // 현재 위치 초기화
	    dx = nx;
	    dy = ny;

	    result += cx + cy;

	    // 마지막 점일 경우 처음 점과의 거리도 계산
	    if (i == N - 1) {

		int ex = 0;
		int ey = 0;

		if (nx >= x) {
		    ex = nx - x;
		} else {
		    ex = x - nx;
		}

		if (ny >= y) {
		    ey = ny - y;
		} else {
		    ey = y - ny;
		}

		result += ex + ey;
	    }
	}
	System.out.println(result);
    }
}