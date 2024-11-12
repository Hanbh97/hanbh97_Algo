import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c;
	static int length, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 한 변의 길이를 계산할 2제곱수 N, 방문 순서를 알고싶은 행 r, 열 c
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// N일때 한 변의 길이
		length = (int)Math.pow(2, N);
		
		// 최댓값
		max = length * length - 1;
		
		// 메서드 실행
		search(0, max, length);
	}
	
	// 해당 인덱스를 찾을 메서드
	static void search(int start, int end, int size) {
		
		// 기저 조건 : 한 변의 길이가 1일 경우
		if(size == 1) {
			System.out.println(start);
			return;
		}
		
		// 이번 사분면에 존재하는 칸의 개수
		int cnt = end - start + 1;
		
		// 사분면으로 나눌 칸의 개수
		int part = cnt / 4;
		
		// 한 변의 절반
		int half = size / 2;
		
		// 조건에 따라 재귀
		// 4개의 사분면으로 나누어 탐색을 진행
		// 사분면마다 r, c를 초기화
		// 2사분면에 위치할 경우
		if(r < half && c < half) {
			search(start, start + part - 1, half);
		}
		
		// 1사분면에 위치할 경우
		else if(r < half && c >= half) {
			c -= half;
			search(start + part, (start + end) / 2, half);
		}
		
		// 3사분면에 위치할 경우
		else if(r >= half && c < half) {
			r -= half;
			search((start + end) / 2 + 1, end - part, half);
		}
		
		// 4사분면에 위치할 경우
		else if(r >= half && c >= half) {
			r -= half;
			c -= half;
			search(end - part + 1, end, half);
		}
	}
}