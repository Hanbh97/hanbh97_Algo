import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동전의 개수 N, 목표 가격 K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 동전을 담을 배열
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// 결과를 담을 변수
		int result = 0;
		
		// 인덱스의 동전만 사용하여 결과값을 구하는 반복문
		for(int i = N - 1; i >= 0; i--) {
			
			// 나누기 계산을 우선 수행
			result += K / coins[i];

			// 해당 인덱스로 나누어질 경우 값을 저장하고 종료
			if(K % coins[i] == 0) {
				break;
			
			// 나누어지지 않는다면 다음 인덱스로 나누어본다.	
			}else {
				K %= coins[i]; 
			}
		}
		
		System.out.println(result);
	}
}