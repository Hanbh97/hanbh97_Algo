import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int N = Integer.parseInt(br.readLine());

	// 찾을 패턴을 초기화
	String pt = "I";

	for (int i = 0; i < N; i++) {
	    pt += "OI";
	}

	// 패턴 길이
	int ptL = pt.length();

	// 문자열의 길이와 문자열
	int SL = Integer.parseInt(br.readLine());
	String S = br.readLine();

	// 카운팅 변수
	int cnt = 0;

	// 패턴 개수 카운팅
	// 탐색은 SL - ptL 만큼만
	for (int i = 0; i <= SL - ptL; i++) {

	    // 앞이 I 일때만 탐색
	    if (S.charAt(i) == 'I') {

		// 앞부터 일치하는지 확인
		// 일치하면 두 칸 이동
		String temp = S.substring(i, i + ptL);

		if (temp.equals(pt)) {
		    cnt++;
		    i++;
		}
	    }
	}
	System.out.println(cnt);
    }
}