import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시작할 이진수를 입력받고 10진수로 변환
		String num = br.readLine();
		BigInteger two = new BigInteger(num, 2);
		
		// 8진수로 변환
		String result = two.toString(8);
		System.out.println(result);
	}
}
