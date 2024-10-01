import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 운동시간 : N
		// 초기 맥박 : m
		// 최대 맥박 : M
		// 증가량 : T
		// 감소량 : R
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 운동한 시간 ex, 전체시간 time
		int ex = 0;
		int time = 0;
		
		// 현재 맥박
		int X = m;
		
		// 운동시간만큼 반복
		while(ex != N) {
			
			// 맥박이 M보다 작거나 같으면 운동 가능
			if(X + T <= M) {
				X += T;
				time++;
				ex++;
			}
			
			// 초기값인데 운동하면 넘어버릴경우
			else if(X == m && X + T > M) {
				time = -1;
				break;
			}
			
			// 아니라면 휴식
			else if(X + T > M){
				X -= R;
				time++;
				
				// 맥박이 m보다 낮아지지 않도록
				if(X < m) {
					X = m;
				}
			}			
		}
		System.out.println(time);
	}
}