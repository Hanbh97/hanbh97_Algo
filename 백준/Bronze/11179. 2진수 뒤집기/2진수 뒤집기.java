import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 변환할 정수
		int N = Integer.parseInt(br.readLine());
		
		// 2진수로 변환
		String two = Integer.toBinaryString(N);
		
		// 쉽게 뒤집기 위해 sb에 삽입하여 뒤집기
		sb.append(two);
		sb.reverse();
		
		// 이진수를 다시 10진수로 변환
		int result = Integer.parseInt(sb.toString(), 2);
		
		System.out.println(result);
	}
}