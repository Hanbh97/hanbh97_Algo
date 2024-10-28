import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 길이
		int N = Integer.parseInt(br.readLine());
		
		// 문자
		String S = br.readLine();
		
		// 문자 배열에 문자를 할당
		char[] lotto = S.toCharArray();
		
		// 인접한 개수에 대한 카운팅 변수
		int cnt = 1;
		
		// 결과 변수
		String result = "NO";
		
		// 로또를 확인할 반복문
		for(int i = 1; i < N; i++) {
			
			// 이전 문자와 인접했다면 +1
			if(lotto[i - 1] == lotto[i] - 1 || lotto[i - 1] == lotto[i] + 1) {
				cnt++;
			}
			
			// 아니라면 다시 1로 초기화
			else {
				cnt = 1;
			}
			
			// 5개가 일치했다면 조기 종료
			if(cnt == 5) {
				result = "YES";
				break;
			}
		}
		System.out.println(result);
	}
}
