import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 학생 수
		int N = Integer.parseInt(br.readLine());
		
		// 키의 최댓값 만큼의 배열을 선언
		int[] student = new int[1001];
		
		// 반복문을 통해 키에 해당하는 인덱스를 카운팅
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			
			// 키를 입력
			int temp = Integer.parseInt(st.nextToken());		
			student[temp]++;
		}
		
		// 배열을 순회하면서 카운팅이 2이하인 경우에는 그냥 더함
		// 2보다 크면 2만 더함
		int sum = 0;
		for(int i = 1; i <= 1000; i++) {
			
			if(student[i] <= 2) {
				sum += student[i];
			}
			
			else {
				sum += 2;
			}
		}
		
		System.out.println(sum);
	}
}