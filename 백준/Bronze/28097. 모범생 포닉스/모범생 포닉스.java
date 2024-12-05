import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();

	// 공부 계획의 수
	int N = Integer.parseInt(br.readLine());

	// 총 시간 변수
	int h = 0;

	// 공부에 필요한 시간
	st = new StringTokenizer(br.readLine());
	for (int i = 0; i < N; i++) {
	    h += Integer.parseInt(st.nextToken());
	}

	// + 쉬는시간
	h += 8 * (N - 1);

	int day = h / 24;
	int hour = h % 24;

	sb.append(day).append(" ").append(hour);
	System.out.println(sb);
    }
}