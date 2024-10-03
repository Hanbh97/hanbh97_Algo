import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 백의 점수와 흑의 점수 변수
		int w = 0;
		int b = 0;
		
		// 반복문을 통해 행을 입력
		for(int r = 0; r < 8; r++) {
			
			// 한 줄을 임시 변수에 저장
			String line = br.readLine();
			
			// 반복문을 통해 인덱스로 쪼갬
			for(int c = 0; c < 8; c++) {
				
				// 문자 하나를 임시 변수에 저장
				char temp = line.charAt(c);
				
				// 기물 점수를 계산
				if(temp == 'p') {
					b += 1;
				}else if(temp == 'P') {
					w += 1;
				}else if(temp == 'n' || temp == 'b') {
					b += 3;
				}else if(temp == 'N' || temp == 'B') {
					w += 3;
				}else if(temp == 'r') {
					b += 5;
				}else if(temp == 'R') {
					w += 5;
				}else if(temp == 'q') {
					b += 9;
				}else if(temp == 'Q') {
					w += 9;
				}
			}
		}
		int result = w - b;
		System.out.println(result);
	}
}