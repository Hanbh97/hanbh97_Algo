import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 명령어의 개수 Q, 나누는 정수 mod
		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		
		// mod 만큼의 스택 배열을 선언
		Stack<Integer>[] stack = new Stack[mod];
		for(int i = 0; i < mod; i++) {
			stack[i] = new Stack<>();
		}
		
		// 현재까지 들어간 수들의 개수를 나타낼 변수
		int cnt = 0;
		
		// 명령어에 대한 작업을 진행
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 첫 번째 수를 확인
			int fst = Integer.parseInt(st.nextToken());
			
			// 처음 수가 1일 경우 삽입을 진행
			if(fst == 1) {
				int snd = Integer.parseInt(st.nextToken());
				
				// 현재 들어간 수 기준 몇 번째 수인지 삽입
				stack[snd % mod].push(cnt++);
			}
			
			// 처음 수가 2일 경우 삭제를 진행
			else if(fst == 2) {
				
				for(int j = 0; j < mod; j++) {
					
					// 현재 스택이 비지 않았으면서
					// 바로 이전에 삽입된 숫자이면 그 수를 삭제
					// 전체 숫자의 개수도 -1
					if(!stack[j].isEmpty() && stack[j].peek() == cnt - 1) {
						stack[j].pop();
						cnt--;
						break;
					}
				}
			}
			
			// 처음 수가 3일 경우 쿼리를 계산
			else if(fst == 3) {

				// 가장 작은 수를 담을 변수
				int min = Integer.MAX_VALUE;
				
				// 스택배열을 순회
				for(int j = 0; j < mod; j++) {
					
					// 비어있는 스택이 있다면 모든 나머지가 없는 것이므로 -1
					// 이후 바로 종료
					if(stack[j].isEmpty()) {
						min = -1;
						break;
					}
					
					// 최소의 인덱스를 갖는 스택을 찾음
					if(stack[j].peek() < min) {
						min = stack[j].peek();
					}
				}
				
				if(min == -1) {
					sb.append(min).append("\n");
				}else {
					sb.append(cnt - min).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}