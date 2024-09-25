import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 네 개의 정수를 저장
		int Ur = Integer.parseInt(st.nextToken());
		int Tr = Integer.parseInt(st.nextToken());
		int Uo = Integer.parseInt(st.nextToken());
		int To = Integer.parseInt(st.nextToken());
		
		// 결과를 저장
		int result1 = 56 * Ur;
		int result2 = 24 * Tr;
		int result3 = 14 * Uo;
		int result4 = 6 * To;
		
		int result = result1 + result2 + result3 + result4;
		System.out.println(result);
		
	}
}