import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 명령어의 수 Q, 나누는 정수 mod
		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		
		// 사용할 스택 배열을 선언
		// 각 나머지 값을 갖는 스택
		// 해당 스택에 인덱스가 삽입
		Stack<Integer>[] arr = new Stack[mod];
		for(int i = 0; i < mod; i++) {			
			arr[i] = new Stack<>();
		}
		
		// 들어온 수의 인덱스를 가리킬 변수
		int idx = 0;
		
		// 반목문으로 명령어를 실행
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 첫 숫자를 확인
			int fst = Integer.parseInt(st.nextToken());
			
			// 1이면 해당 나머지 인덱스 스택에 삽입
			if(fst == 1) {
				int scd = Integer.parseInt(st.nextToken());
				arr[scd % mod].push(idx++);
			}
			
			// 2면 스택배열을 순회하면서 가장 위의 원소가 가장 최근인 것을 제거
			// 제거했으므로 idx - 1
			else if(fst == 2) {
				
				for(int j = 0; j < mod; j++) {
					
					if(!arr[j].isEmpty() && arr[j].peek() == idx - 1) {
						arr[j].pop();
						idx--;
						break;
					}
				}
			}
			
			// 3이면 쿼리 값을 계산
			else {
				
				// 최솟값을 저장할 변수
				int min = Integer.MAX_VALUE;
				
				// 스택배열을 순회하며 가장 위의 원소가 가장 작은 값을 저장
				// 해당 인덱스까지 뽑아야 한다는 의미이므로 idx - min
				// 0인 스택이 하나라도 존재한다면 쿼리값은 없음
				for(int j = 0 ; j < mod; j++) {
					
					if(arr[j].size() == 0) {
						min = -1;
						break;
					}
					
					
					if(arr[j].peek() < min) {
						min = arr[j].peek();
					}
				}
				
				// min에 -1이 있다면 그대로 min을 출력
				// 아니면 idx - min을 출력
				if(min == -1) {
					sb.append(min).append("\n");
				}else {
					sb.append(idx - min).append("\n");					
				}
			}
		}
		System.out.println(sb);
	}
}