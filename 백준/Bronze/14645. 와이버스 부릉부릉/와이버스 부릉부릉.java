import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정거장 수 N, 시작시 탑승하는 사람 수 K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// N만큼 반복 (근데 의미있나?)
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 탑승 인원 A, 하차 인원 B
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		}
		
		System.out.println("비와이");
	}	
}