import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 플레이어 수
		int N = Integer.parseInt(br.readLine());
		
		// 플레이어 수 만큼의 배열을 선언
		// 0을 제외하므로 크기는 N + 1
		int[] player = new int[N + 1];
		
		// 반복문을 통해 카운팅
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			
			int temp = Integer.parseInt(st.nextToken());
			
			// 0이 아닐 경우에만 카운팅
			if(temp != 0) {
				player[temp]++;				
			}
		}
		
		// 배열을 순회하면서 가장 많은 카운팅을 뽑기
		// 해당 인덱스도 저장
		int max = 0;	
		int idx = 0;
		for(int i = 1; i <= N; i++) {			
			if(max <= player[i]) {
				max = player[i];
				idx = i;
			}
		}
		
		// 최대 개수가 여러개일 경우를 판단
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(max == player[i]) {
				cnt++;
			}
		}
		
		// 최대가 여러개일 경우
		if(cnt > 1) {
			System.out.println("skipped");
		
		// 하나 뿐일 경우
		}else {
			System.out.println(idx);
		}
	}
}