import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Node {
    int node, cost;
    
    Node(int node, int cost){
      this.node = node;
      this.cost = cost;
    }
  }
  
  static int V, E, K;
  
  static int INF = Integer.MAX_VALUE;
  static List<Node>[] adjList;
  static int[] dist;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    // 정점의 개수 V, 간선의 개수 E
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    
    // 시작지점
    K = Integer.parseInt(br.readLine());
    
    // 인접 리스트 선언
    adjList = new ArrayList[V + 1];
    for(int i = 0; i <= V; i++) {
      adjList[i] = new ArrayList<>();
    }
    
    // 최소 비용을 담을 배열
    dist = new int[V + 1];
    
    // 최소 비용 계산을 위해 INF로 fill
    Arrays.fill(dist, INF);
    
    // 인접 리스트 초기화
    for(int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      
      // a에서 b로 이동하며 비용은 c
      adjList[a].add(new Node(b, c));
      
    }
    
    // 다익스트라 시작
    dijkstra(K);
    
    for(int i = 1; i <= V; i++) {
      
      if(dist[i] == INF) {
        sb.append("INF").append("\n");
      }
      else {
        sb.append(dist[i]).append("\n");        
      }
    }
    System.out.println(sb);
  }
  
  // 다익스트라 메서드
  static void dijkstra(int start) {
    
    // 방문 배열을 선언
    boolean[] check = new boolean[V + 1];
    
    // 시작은 0
    dist[start] = 0;
    
    // 본인을 제외하고 다른 정점으로 이동하므로 
    // V - 1 만큼 반복
    for(int i = 0; i < V - 1; i++) {
      int min = INF;
      int idx = -1;
      
      // 반복문을 통해 넘어갈 수 있는 정점을 확인
      for(int j = 0; j <= V; j++) {
        
        // 아직 방문하지 않았으면서 가중치가 더 적은 것을 선택
        // 초기에는 시작점을 찾음
        if(!check[j] && dist[j] < min) {
          min = dist[j];
          idx = j;
        }
      }
      
      // 다음으로 이동할 인덱스가 -1면 갈 수 있는게 없음
      if(idx == -1) break;
      
      // 다음으로 이동할 지점을 방문체크
      check[idx] = true;
      
      // 노드를 순회하며 가중치 적용
      // 이동한 곳과 연결되는 것들을 순회
      for(Node n : adjList[idx]) {
        
        // 아직 방문하지 않았으면서
        // 이미 존재하는 이동 누적 값보다 이동한 곳에서 가중치를 계산한 값이 더 적다면
        if(!check[n.node] && dist[n.node] > dist[idx] + n.cost) {
          dist[n.node] = dist[idx] + n.cost;
        }
      }
    }
  }
}