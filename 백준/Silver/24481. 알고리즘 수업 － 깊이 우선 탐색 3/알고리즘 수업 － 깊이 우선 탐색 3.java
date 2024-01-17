import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Integer>> node; //무방향 그래프
	static boolean[] visited; //DFS 방문배열
	static int N; //정점의 수
	static int M; //간선의 수
	static int R; //시작 정점
	static int[] result; //정답 배열
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의 수
		M = Integer.parseInt(st.nextToken()); //간선의 수
		R = Integer.parseInt(st.nextToken()); //시작 정점
		
		nodeSet();//양방향(무방향) 그래프 설정 및 초기화
		visited = new boolean[N+1];//DFS 방문배열 설정 및 초기화
		result = new int[N+1];//정답 배열 설정 및 초기화
		
		for(int i=0; i<=N; i++) {
			result[i] = -1;
		}
		
		DFS(R,0);
		
//		System.out.println(Arrays.toString(result));
		
		resultView();
		
		
		
	}
	
	public static void nodeSet() throws IOException { //양방향(무방향)그래프 설정
		node = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			node.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node.get(a).add(b);
			node.get(b).add(a);
			
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(node.get(i));
		}
		
	}
	
	public static void DFS(int v,int depth) {//깊이 우선 탐색
		visited[v] = true;
		result[v] = depth;
		
		for(int i=0; i<node.get(v).size(); i++) {
			if(!visited[node.get(v).get(i)]) {
				DFS(node.get(v).get(i),depth+1);
			}
		}
		
	}
	
	public static void resultView() {//정답 배열 확인
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
	}
	
}