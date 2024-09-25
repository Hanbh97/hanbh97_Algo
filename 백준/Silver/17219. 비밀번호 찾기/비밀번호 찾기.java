import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사이트 주소의 수 N, 비밀번호를 찾으려는 사이트 주소의 수 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 사이트 주소와 비밀번호를 담는 맵을 선언
		Map<String, String> map = new HashMap<>();
		
		// 맵에 주소와 비밀번호를 할당
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String site = st.nextToken();
			String password = st.nextToken();
			
			map.put(site, password);
		}
		
		// M만큼 반복하면서 key에 해당하는 value를 저장
		for(int i = 0; i < M; i++) {
			String target = br.readLine();
			
			sb.append(map.get(target)).append("\n");
		}
		
		System.out.println(sb);
	}
}