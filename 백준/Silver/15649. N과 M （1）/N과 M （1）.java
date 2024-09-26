import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static int[] nums;
	static boolean[] visited;
	static int[] result;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		visited = new boolean[N];
		result = new int[M];
		
		for(int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}
		
		getArr(0);
		
	}
	
	static void getArr(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == true) {
				continue;
			}
			
			result[idx] = nums[i];
			visited[i] = true;
			getArr(idx + 1);
			visited[i] = false;
		}
	}
}