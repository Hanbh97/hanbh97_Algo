import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 시작 시간
		int sh = Integer.parseInt(st.nextToken());
		int sm = Integer.parseInt(st.nextToken());
		
		// 끝 시간
		st = new StringTokenizer(br.readLine());
		int eh = Integer.parseInt(st.nextToken());
		int em = Integer.parseInt(st.nextToken());
		
		// 원하는 숫자
		String num = br.readLine();
		
		// 카운팅 변수
		int cnt = 0;
		
		while (sh < eh || (sh == eh && sm <= em)) {
			String temp1 = String.format("%02d", sh);  // 두 자리로 포맷
			String temp2 = String.format("%02d", sm);  // 두 자리로 포맷
			
			// 수가 존재하면 카운팅
			if (temp1.contains(num) || temp2.contains(num)) {
				cnt++;
			}

			sm++; // 분 증가
			if (sm == 60) {
				sh++;
				sm = 0;
			}
		}
		System.out.println(cnt);
	}
}
