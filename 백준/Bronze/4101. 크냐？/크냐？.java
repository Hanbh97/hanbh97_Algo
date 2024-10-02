import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력이 0, 0일때까지 반복
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 둘 다 0이면 종료
			if(a == 0 && b == 0) {
				break;
			}
			
			// 앞이 크면 Yes
			if(a > b) {
				sb.append("Yes").append("\n");
			}
			// 아니면 No
			else {
				sb.append("No").append("\n");
			}
		}
		System.out.println(sb);
	}	
}