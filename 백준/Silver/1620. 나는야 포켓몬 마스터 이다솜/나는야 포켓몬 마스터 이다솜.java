import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도감에 저장할 포켓몬 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 맞춰야할 문제 수
		int M = Integer.parseInt(st.nextToken());
		
		// 도감 배열
		String[] pokemon = new String[N];
		
		// 사용할 Map을 선언
		Map<String, Integer> map = new HashMap<>();	
		
		for(int i = 0 ; i < N; i++) {
			String temp = br.readLine();
			
			pokemon[i] = temp;
			map.put(temp, i + 1);
		}
		
		// 문제를 맞출 반복문
		// 첫 인덱스가 1-9이면 숫자로 판별
		for(int i = 0; i < M ; i++) {
			String line = br.readLine();
			char first = line.charAt(0);
			
			// 숫자면 배열에서 인덱스로서 접근
			if('0' <= first && first <= '9') {
				
				// 정수로 바꾸로 저장
				int search = Integer.parseInt(line);
				sb.append(pokemon[search - 1]).append("\n");
			
			// 문자면 Map에서 value로 접근
			}else {
				sb.append(map.get(line)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
