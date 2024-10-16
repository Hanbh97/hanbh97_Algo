import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 친구 수
		int N = Integer.parseInt(br.readLine());
		
		// 친구 트랙을 저장할 배열을 선언 및 초기화
		String[] track = new String[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			track[i] = st.nextToken();
		}
		
		// 헬로빗의 트랙
		String me = br.readLine();
		
		// 결과 변수
		int cnt = 0;
		
		// 배열을 순회하면서 동일한 개수를 카운팅
		for(int i = 0; i < N; i++) {
			
			if(me.equals(track[i])) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
