import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사람 수, 원하는 차례
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		// 조건에 맞게 반복
		int cnt = 1;
		int result = 0;
		boolean check = false;
		while(cnt <= T) {
			
			// false이면 증가
			if(!check) {
				result++;
				cnt++;
				
				// 2*N 이되면 반대로
				if(result == 2 * N) {
					check = true;
				}
			}
			// true면 감소
			else {
				result--;
				cnt++;
				
				// 1이 되면 다시 증가
				if(result == 1) {
					check = false;
				}
			}
		}
		System.out.println(result);
	}
}