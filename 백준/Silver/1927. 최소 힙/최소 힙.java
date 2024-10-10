import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 사용할 우선순위 큐를 선언
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		
		// 연산할 횟수
		int N = Integer.parseInt(br.readLine());
		
		// N만큼 삽입
		for(int i = 0; i < N; i++) {
			Long num = Long.parseLong(br.readLine());
			
			// 해당 수가 자연수라면 삽입
			if(num > 0) {
				minHeap.add(num);				
			}
			
			// 0이라면 가장작은 수를 출력하고 제거
			else {
				
				// 힙에 아무것도 없다면 0을 출력
				if(minHeap.size() == 0) {
					sb.append(0).append("\n");
				}
				
				// 있다면 가장작은 수를 출력
				else {
					Long min = minHeap.poll();
					sb.append(min).append("\n");					
				}
				
			}
		}
		System.out.println(sb);
	}	
}
