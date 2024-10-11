import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 문자열의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 끝말잇기가 가능한지 판단할 변수
		int result = 1;
		
		// 처음 단어의 앞글자 뒷글자를 담을 변수		
		st = new StringTokenizer(br.readLine());
		String first = st.nextToken();
		
		char f = first.charAt(0);
		char e = first.charAt(first.length() - 1);
		
		// 나머지 문자열의 처음과 끝을 확인
		for(int i = 1; i < N; i++) {
			
			String line = st.nextToken();			

			// 다른 것이 있다면 결과를 0으로
			if(f != line.charAt(0) || e != line.charAt(line.length() - 1)) {
				result = 0;
			}
		}
		
		System.out.println(result);
	}
}
