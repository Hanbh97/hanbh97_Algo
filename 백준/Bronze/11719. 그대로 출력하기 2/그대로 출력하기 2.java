import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 문자를 입력받을 변수
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}	
}
