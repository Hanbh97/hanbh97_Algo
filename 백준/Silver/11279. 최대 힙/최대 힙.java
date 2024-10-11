import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 사용할 우선순위 큐를 선언
		// 기본적으로 오름차순이므로 내림차순으로 바꿔줌
		PriorityQueue<Integer> hip = new PriorityQueue<>(Collections.reverseOrder());
		
		// 연산의 개수
		int N = Integer.parseInt(br.readLine());
		
		// N만큼 반복
		for(int i = 0; i < N; i++) {
			
			// 입력 수를 저장
			int num = Integer.parseInt(br.readLine());
			
			// 자연수일 경우 수를 삽입
			if(num != 0) {
				hip.add(num);
			}
			
			// 0일 경우 현재 가장 큰 수를 추출
			else {
				
				// 수가 없을 경우
				if(hip.size() == 0) {
					sb.append(0).append("\n");
				}
				
				// 있을 경우 그 수를 추출
				else {					
					sb.append(hip.poll()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
