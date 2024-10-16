import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받을 문자와 확인할 문자
		String line = br.readLine();
		String driip = "driip";
		
		// driip의 인덱스 변수
		int idx = 0;
		
		// 귀여운지 확인할 변수
		boolean check = true;
		
		// 문자열 길이를 보고 분기
		// 길이가 5보다 작다면 바로 false
		if(line.length() < 5) {
			check = false;
		}
		
		// 아니라면 문자열의 뒤에서 5번째부터 확인
		else {
			for(int i = line.length() - 5; i < line.length(); i++) {
				
				// 문자가 같지않다면 false 후 종료
				if(line.charAt(i) != driip.charAt(idx++)) {
					check = false;
					break;
				}
			}			
		}
		
		if(check) System.out.println("cute");
		else System.out.println("not cute");
	}
}
