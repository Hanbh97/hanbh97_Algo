import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학교의 층수 n, 한 층에 있는 교실의 수 m, 레이스에 참가하는 반의 수 k
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 최단 거리와 반
		int min = Integer.MAX_VALUE;
		int cls = 0;
		
		// 반 마다 최단 거리를 계산
		for(int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 반의 위치
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 최단 거리 계산
			int length = (r - 1) + (m - c);
			
			// 최단거리 갱신일 때, 반을 갱신
			if(min > length) {
				min = length;
				cls = i;
			}
		}
		System.out.println(cls);
	}
}