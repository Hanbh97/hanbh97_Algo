import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		// 테스트케이스 만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			
			// 가지고있는 의상 개수
			int n = Integer.parseInt(br.readLine());
			
			// 사용할 map을 선언
			Map<String, Integer> map = new HashMap<>();
			
			// 한 줄을 입력
			// 뒤의 종류만 사용
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				// 이미 존재하는 종류이면
				if(map.containsKey(b)) {
					
					// 해당 key에 value를 하나 늘려주고 초기화
					map.put(b, map.get(b) + 1);
					
				}

				// 없는 종류면 삽입
				else {
					map.put(b, 1);					
				}
				
			}

			// 모든 경우의 수는 종류들의 +1을 모두 곱한값
			// +1은 선택하지 않은 경우
			// 마지막에 전체가 없는 경우를 -1
			// 곱해줘야하므로 결과는 1로 초기화
			int result = 1;
			for(int i : map.values()) {
				result *= (i + 1);
			}
			
			sb.append(result - 1).append("\n");
		}
		System.out.println(sb);
	}	
}