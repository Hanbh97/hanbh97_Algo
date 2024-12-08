import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	// 트랙수 N과 증가량 K
	Long N = Long.parseLong(st.nextToken());
	Long K = Long.parseLong(st.nextToken());

	// 가능 변수
	boolean check = true;

	// 시행 횟수 변수
	Long cnt = 0L;

	// 트랙 길이 순회와 동시에 가능성 판별
	// 앞 길이와 비교
	st = new StringTokenizer(br.readLine());

	Long len = 0L;

	for (int i = 0; i < N; i++) {

	    if (i == 0) {
		len = Long.parseLong(st.nextToken());
	    }

	    else {
		Long temp = Long.parseLong(st.nextToken());

		if (temp > len) {
		    len = temp;
		    continue;

		} else {
		    temp += K;
		    cnt++;

		    if (temp > len) {
			len = temp;
			continue;

		    } else {
			check = false;
			break;
		    }
		}
	    }
	}
	if (check) {
	    System.out.println(cnt);
	} else {
	    System.out.println(-1);
	}
    }
}