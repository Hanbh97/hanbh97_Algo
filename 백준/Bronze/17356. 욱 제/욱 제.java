import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 욱의 욱제력 A, 제의 욱제력 B
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		
		// M 계산
		double M = (B - A) / 400;

		// 욱이 제를 이길 확률 계산
		double result = 1 / (1 + Math.pow(10, M));
		
		System.out.println(result);
	}	
}