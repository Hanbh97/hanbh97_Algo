import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    // 현재 위치 N, 동생의 위치 K
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    // 최단 시간을 저장할 배열
    int[] time = new int[100001];
    
    // 방문 확인을 위해 -1로 초기화
    Arrays.fill(time, -1);
    
    // bfs를 사용하기 위한 큐 선언
    Queue<Integer> q = new LinkedList<>();
    
    // 시작점을 큐에 삽입후 방문 체크
    q.add(N);
    time[N] = 0;
    
    // 걸린 시간
    int t = 0;
    
    // bfs를 진행할 반복문
    while(!q.isEmpty()) {
      
      
      
      int temp = q.poll();
      
      // x2 를 진행하는 단계부터 탐색
      // 아직 방문하지 않았으면서 범위를 벗어나지 않을 경우
      if(temp * 2 <= 100000 && time[temp * 2] == -1) {
        q.add(temp * 2);
        time[temp * 2] = time[temp] + 1;
      }
      
      // 앞으로 진행할 때
      if(temp + 1 <= 100000 && time[temp + 1] == -1) {
        q.add(temp + 1);
        time[temp + 1] = time[temp] + 1;
      }
      
      // 뒤로 진행할 때
      if(temp - 1 >= 0 && time[temp - 1] == -1) {
        q.add(temp - 1);
        time[temp - 1] = time[temp] + 1;
      }
    }
    System.out.println(time[K]);
  }
}