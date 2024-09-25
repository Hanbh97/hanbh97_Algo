import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 각각 주문한 치킨 수
		int N = Integer.parseInt(br.readLine());
		
		// 인덱스별로 선호하는 병사들의 수를 담은 배열
		int[] nums = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 결과를 담을 변수
		int result = 0;
		
		// 반복문을 통해 최대 인원수를 초기화
		for(int i = 0 ; i < 3; i++) {
			
			// 주문한 수량보다 많거나 같으면
			if(nums[i] >= N) {
				
				// N밖에 못하므로 N을 더함
				result += N;
			
			// 주문한 수량보다 적다면 병사 수 만큼 더함	
			}else {
				result += nums[i];
			}
		}
		System.out.println(result);
	}
}