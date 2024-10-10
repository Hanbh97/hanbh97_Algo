import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	
	static String start, end;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기 문자
		start = br.readLine();
		
		// 만드려는 문자
		end = br.readLine();
		
		// 시작은 0으로 초기화
		result = 0;
		
		make(start, end);
		System.out.println(result);
	}
	
	// 해당 문자를 만들 수 있는지 찾을 메서드
	static void make(String start, String end) {
		StringBuilder sb = new StringBuilder();		

		if(start.length() == end.length()) {			
			if(start.equals(end)) {
				result = 1;
				return;				
			} else {
				return;				
			}
		}
		
		// 현재 문자열을 임시로 담을 변수
		String temp1 = start;
		
		// 뒤에 A를 붙이는 경우
		temp1 += "A";	
		
		// 문자열을 뒤집고 B를 추가하는 경우
		for(int i = start.length() - 1; i >= 0; i--) {
			sb.append(start.charAt(i));
		}
		
		sb.append("B");
		
		// 현재 변경한 모양이 존재하거나, 다음에 변경할 모습이 존재할 경우
		// 재귀로 다음단계
		if(end.contains(temp1) || end.contains(sb) || end.contains(temp1) || end.contains(reverse(sb + ""))) {
			make(temp1, end);			
			make(sb + "", end);
		}
	}
	
	static String reverse(String st) {
		StringBuilder sb = new StringBuilder();	
		for(int i = st.length() - 1; i >= 0; i--) {
			sb.append(st.charAt(i));
		}
		sb.append("B");
		return sb + "";
	}
}
