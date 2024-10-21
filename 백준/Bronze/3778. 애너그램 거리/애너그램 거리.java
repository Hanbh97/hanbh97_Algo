import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스 수
		int N = Integer.parseInt(br.readLine());
		
		// 테스트케이스만큼 반복
		for(int tc = 1; tc <= N; tc++) {
			
			// 비교할 두 문자열을 입력
			String lineA = br.readLine();
			String lineB = br.readLine();
			
			// 해당 문자열만큼 크기를 갖는 배열과 방문배열을 선언
			char[] arrA = lineA.toCharArray();
			char[] arrB = lineB.toCharArray();
			
			boolean[] checkA = new boolean[lineA.length()];
			boolean[] checkB = new boolean[lineB.length()];
			
			// 반복을 통해 동일한 문자를 체크
			for(int i = 0; i < lineA.length(); i++) {
				for(int j = 0; j < lineB.length(); j++) {
					
					// 비교군이 아직 체크되지 않았으면서 문자가 동일하면
					if(!checkB[j] && arrA[i] == arrB[j]) {
						checkA[i] = true;
						checkB[j] = true;
						break;
					}
				}
			}
			
			// 체크되지 않은 개수를 확인
			int cnt = 0;
			
			for(int i = 0; i < lineA.length(); i++) {
				if(!checkA[i]) cnt++;
			}
			
			for(int i = 0; i < lineB.length(); i++) {
				if(!checkB[i]) cnt++;
			}
			
			sb.append("Case #").append(tc).append(": ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}