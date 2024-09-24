import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 진행할 연산의 수
		int M = Integer.parseInt(br.readLine());
		
		// 인덱스에 해당하는 수들을 담을 배열
		int[] nums = new int[20];
		
		// M만큼 반복
		for(int tc = 0; tc < M; tc++) {
			
			// 입력된 연산을 확인
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			// add이면
			if(order.contains("add")) {
				int num = Integer.parseInt(st.nextToken());
				
				// 1로 초기화
				nums[num - 1] = 1;
			}
			
			// remove이면
			else if(order.contains("remove")) {
				int num = Integer.parseInt(st.nextToken());
				
				// 0으로 초기화
				nums[num - 1] = 0;
			}
			
			// check이면
			else if(order.contains("check")) {
				int num = Integer.parseInt(st.nextToken());
				
				// 1일때(있을때) 1, 0일때(없을때) 0
				if(nums[num - 1] == 1) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
			
			// toggle이면
			else if(order.contains("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				
				// 1이면(있으면) 0으로, 0이면(없으면) 1로
				if(nums[num - 1] == 1) {
					nums[num - 1] = 0;
				}else {
					nums[num - 1] = 1;
				}
			}
			
			// all이면
			else if(order.contains("all")) {
				
				// 전체가 다 있어야하므로 전체를 1로
				for(int i = 0; i < 20; i++) {
					nums[i] = 1;
				}
			}
			
			// empty면
			else if(order.contains("empty")) {
				
				// 전체가 없어야 하므로 전체를 0으로
				for(int i = 0; i < 20; i++) {
					nums[i] = 0;
				}
			}
		}
		System.out.println(sb);
	}
}