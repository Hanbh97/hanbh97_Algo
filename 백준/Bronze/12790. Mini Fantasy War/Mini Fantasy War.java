import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();

	// 테스트케이스
	int T = Integer.parseInt(br.readLine());

	for (int tc = 1; tc <= T; tc++) {
	    st = new StringTokenizer(br.readLine());

	    int hp = Integer.parseInt(st.nextToken());
	    int mp = Integer.parseInt(st.nextToken());
	    int ad = Integer.parseInt(st.nextToken());
	    int df = Integer.parseInt(st.nextToken());

	    // 장비 착용
	    hp += Integer.parseInt(st.nextToken());
	    if (hp < 1) {
		hp = 1;
	    }

	    mp += Integer.parseInt(st.nextToken());
	    if (mp < 1) {
		mp = 1;
	    }

	    ad += Integer.parseInt(st.nextToken());
	    if (ad < 0) {
		ad = 0;
	    }

	    df += Integer.parseInt(st.nextToken());

	    // 최종 전투력
	    int result = hp + 5 * mp + 2 * ad + 2 * df;

	    sb.append(result).append("\n");
	}
	System.out.println(sb);
    }
}