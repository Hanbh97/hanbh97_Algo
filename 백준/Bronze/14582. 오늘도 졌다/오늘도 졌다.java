import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 누적 점수를 계산 각각의 배열
		// 0을 제외하며 초와 말까지 이므로 *2 +1
		int[] u = new int[19];
		int[] s = new int[19];
		
		// 정수를 입력받으면서 누적합을 계산하여 초기화
		// 울림 제미니스 점수
		for(int i = 1; i <= 18; i += 2) {			
			int score = Integer.parseInt(st.nextToken());			
			u[i] = u[i - 1] + score;
			u[i + 1] = u[i];
		}
		
		// 스타트링크 걸리버스 점수
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 18; i += 2) {			
			int score = Integer.parseInt(st.nextToken());			
			s[i] = s[i - 1];
			s[i + 1] = s[i] + score;
		}
		
		// 제미니스가 이긴적이 있는지 확인할 변수
		boolean win = false;
		
		// 배열을 순회하며 확인
		for(int i = 1; i <= 18; i++) {
			
			// 제미니스가 더 크다면 true
			if(u[i] > s[i]) {
				win = true;
			}
		}
		
		// 배열 순회 후 변수에 따른 결과 출력
		if(win) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
