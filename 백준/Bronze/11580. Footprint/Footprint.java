import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int L;
	static String line;
	static char[] dir;
	static int[] x, y;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 내릴 명령의 수
		L = Integer.parseInt(br.readLine());
		
		// 입력받은 문자열로 배열 초기화
		line = br.readLine();
		
		// 문자열을 쪼갠 배열을 선언
		dir = line.toCharArray();
		
		// 이동하는 위치의 좌표를 담을 배열 선언
		// 원점은 제외하므로 +1
		x = new int[L + 1];
		y = new int[L + 1];
		
		// 발자국 수 변수
		// 원점에 하나 존재하므로
		int cnt = 1;
		
		// 중복값이 있는지 확인할 변수
		boolean same = false;
		
		// L만큼 반복하여 명령어를 판단
		for(int i = 0 ; i < L; i++) {
			
			// 방향에 따라 위치를 초기화 후 중복 확인 메서드 실행
			if(dir[i] == 'E') {

				// 중복되지 않았다면 개수를 늘려줌
				same = check(x[i] + 1, y[i]);
				
				x[i + 1] = x[i] + 1;
				y[i + 1] = y[i];
				
				if(!same) {
					cnt++;
				}
				
			}else if(dir[i] == 'S') {

				same = check(x[i], y[i] - 1);
				
				x[i + 1] = x[i];
				y[i + 1] = y[i] - 1;
				
				if(!same) {
					cnt++;
				}
					
			}else if(dir[i] == 'W') {

				same = check(x[i] - 1, y[i]);
				
				x[i + 1] = x[i] - 1;
				y[i + 1] = y[i];
				
				if(!same) {
					cnt++;
				}
					
			}else if(dir[i] == 'N') {

				same = check(x[i], y[i] + 1);
				
				x[i + 1] = x[i];
				y[i + 1] = y[i] + 1;
				
				if(!same) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	// 이미 배열에 존재하는지 확인할 메서드
	static boolean check(int r, int c) {
		
		// 배열을 순회
		for(int i = 0; i <= L; i++){
			
			// 해당 짝이 존재하면
			if(r == x[i] && c == y[i]) {
				return true;
			}
		}
		
		return false;
	}
}
