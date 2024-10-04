import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 모든 수들의 합을 담을 변수
		int sum = 0;
		
		// 수들을 담을 배열을 선언 및 초기화
		int[] nums = new int[9];
		for(int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		
		// 100과의 차이를 확인할 변수
		int cha = sum - 100;
		
		// 반복문을 돌면서 수 두 개를 뽑아 차이만큼인지 확인
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				
				// 두 수를 발견하면 100으로 초기화하고 멈춤
				if(nums[i] + nums[j] == cha) {
					nums[i] = 100;
					nums[j] = 100;
					break;
				}
			}
		}

		// 배열을 돌면서 순서대로 출력
		for(int i = 0; i < 9; i++) {
			if(nums[i] != 100) {
				sb.append(nums[i]).append("\n");
			}
		}
		System.out.println(sb);
	}	
}