import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 주어진 카드 개수
		int N = Integer.parseInt(br.readLine());
		
		// 인덱스에 해당하는 수들을 담을 두 배열을 선언
		// 배열의 크기는 주어진 카드에 담을 수의 범위만큼 할당
		// 두 배열 모두 0을 포함하므로 +1
		int[] plus = new int[10000001];
		int[] minus = new int[10000001];
		
		// 카드 번호에 해당하는 인덱스를 카운팅
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 해당수가 양수인지 음수인지 판별하여 해당 인덱스를 증가
			if(num >= 0) {
				plus[num]++;
			}else {
				minus[0 - num]++;
			}
		}
		
		// 확인할 카드 수
		int M = Integer.parseInt(br.readLine());
		
		// 해당 카드의 카운팅을 확인할 반복문
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int search = Integer.parseInt(st.nextToken());
			
			// 확인하는 수가 양수인지 음수인지 판별하여 해당 인덱스를 확인
			if(search >= 0) {
				sb.append(plus[search]).append(" ");
			}else {
				sb.append(minus[0 - search]).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}