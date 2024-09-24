import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static String[] L;
	static String[] S;
	static String[] tempL;
	static String[] tempS;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		// 듣도 못한 사람 수
		N = Integer.parseInt(st.nextToken());
		
		// 보도 못한 사람 수
		M = Integer.parseInt(st.nextToken());
		
		// 듣, 보를 담을 두 배열과 병합 정렬을 위한 temp 배열을 선언
		L = new String[N];
		S = new String[M];
		tempL= new String[N];
		tempS = new String[M];
		
		// 듣 할당
		for(int i = 0; i < N; i++) {
			L[i] = br.readLine();
		}
		
		// 보 할당
		for(int i = 0; i < M; i++) {
			S[i] = br.readLine();
		}
		
		// 이진 탐색을 통해 동일한 값들을 추출
		// 우선 배열들의 정렬이 필요
		// 메서드를 사용하여 정렬
		div(L, tempL, 0, N - 1);
		div(S, tempS, 0, M - 1);
		
		// 이진탐색을 통해 겹치는 사람만 추출 
		for(int i = 0 ; i < N ; i++) {
			search(L[i], 0, M - 1);
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	// 병합정렬 1단계 : 나누기
	static void div(String[] arr, String[] temp, int left, int right) {
		
		// 왼쪽 끝이 오른쪽 끝보다 크거나 같아지면 재귀 탈출
		if(left >= right) {
			return;
		}
		
		// 중간값 지정
		int mid = (left + right) / 2;
		
		// 배열을 계속 나누어줄 재귀
		div(arr, temp, left, mid);
		div(arr, temp, mid + 1, right);
		
		// 나눈 배열을 다시 합칠 메서드
		sort(arr, temp, left, mid, right);
	}
	
	// 병합정렬 2단계 : 정렬 후 합치기
	static void sort(String[] arr, String[] temp, int left, int mid, int right) {
		
		// 왼쪽 시작 값과 오른쪽 시작 값을 저장
		int L = left;
		int R = mid + 1;
		
		// temp에 넣어줄 순서인 인덱스 변수
		int idx = left;
		
		// 두 시작 점이 끝에 도달할 때까지
		while(L <= mid && R <= right) {
			
			// 사전순 정렬
			// compareTo 결과가 음수이면 역순이므로 소팅이 필요
			if(arr[L].compareTo(arr[R]) > 0) {
				temp[idx++] = arr[R++];
			}else {
				temp[idx++] = arr[L++];
			}
		}
		
		// 끝점 도달후 어느 한 쪽이 남아있다면 모두 할당
		while(L <= mid) {
			temp[idx++] = arr[L++];
		}
		
		while(R <= right) {
			temp[idx++] = arr[R++];
		}
		
		// temp배열의 원소를 arr에 다시 담아 정렬
		for(int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}
	
	// 이진탐색
	static void search(String target, int start, int end) {
				
		while(start <= end) {
			
			int mid = (start + end) / 2;
			
			if(S[mid].compareTo(target) > 0) {
				end = mid - 1;
			}else if(S[mid].compareTo(target) < 0) {
				start = mid + 1;
			}else {
				sb.append(S[mid]).append("\n");
				cnt++;
				break;
			}
		}
	}
}
