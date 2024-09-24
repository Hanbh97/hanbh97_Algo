import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 수의 개수
		int n = Integer.parseInt(br.readLine());
		
		// 주어진 수열을 담는 배열
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		// 사용할 스택을 선언
		Stack<Integer> stack = new Stack<>();
		
		// 수열과 일치하도록 pop, push 작업 진행
		// 수열의 인덱스를 다리킬 변수
		int idx = 0;
		for(int i = 0; i < n; i++) {
			
			// 우선 오름차순으로 삽입
			stack.push(i + 1);
			sb.append("+").append("\n");
			
			// 주어진 순열과 같은 수가 나오면
			if((i + 1) == nums[idx]) {
				
				// 수열과 다른 값이 나올 때까지 반복
				while(nums[idx] == stack.peek()) {
					
					// 스택에서 추출
					stack.pop();
					sb.append("-").append("\n");
					
					// 인덱스를 한칸 이동
					idx++;
					
					// 인덱스가 끝까지 갔거나 스택이 비어있으면 종료
					if(idx == n || stack.isEmpty()) break;
				}
			}
		}
		
		// 모든 작업이 끝났는데 스택이 비어있지 않다면
		// 해당 수열은 불가능
		if(!stack.isEmpty()) {
			
			// sb초기화
			sb.delete(0, sb.length());
			sb.append("NO");
		}
		System.out.println(sb);
	}
}