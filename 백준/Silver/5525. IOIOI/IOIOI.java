import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 패턴의 크기
	int N = Integer.parseInt(br.readLine());

	// 문자열 길이
	int SL = Integer.parseInt(br.readLine());

	// 문자열
	String S = br.readLine();

	// 인덱스
	int idx = 0;

	// 부분 패턴의 개수와 전체 패턴의 개수
	int pt = 0;
	int cnt = 0;

	// 문자열을 순회하면서 확인
	while (idx < SL - 2) {

	    // 시작이 I이면
	    if (S.charAt(idx) == 'I') {

		// 이후 O과 I가 연달아 나오면
		// 부분 패턴 1 증가 후, 인덱스 이동
		if (S.charAt(idx + 1) == 'O' && S.charAt(idx + 2) == 'I') {
		    pt++;
		    idx += 2;
		}

		// 부분패턴이 없으면 개수 초기화 후 이동
		else {
		    pt = 0;
		    idx++;
		}

	    }

	    // 시작이 O면 패턴 개수 초기화 후 인덱스 이동
	    else {
		pt = 0;
		idx++;
	    }

	    // 부분 패턴 개수와 N이 일치하면 패턴 개수 증가
	    // 다음에 OI가 다시 나올 수 있으므로
	    // 부분 패턴 개수만 -1
	    if (pt == N) {
		cnt++;
		pt--;
	    }
	}
	System.out.println(cnt);
    }
}