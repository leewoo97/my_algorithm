import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list; 
	static int[] visited; //방문배열
	static int depth;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점 수
		M = Integer.parseInt(st.nextToken()); //간선 수
		int R = Integer.parseInt(st.nextToken()); //시작 정점
		
		listSet();
		visitedSet();
		depth = 1;
		DFS(R);
		
		for(int i=1; i<=N; i++) {
			System.out.println(visited[i]);
		}
		
		
	}
	
	public static void listSet() throws IOException {
		list = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=0; i<=N; i++) {
			Collections.sort(list.get(i));
		}
		
	}
	
	public static void visitedSet() {
		visited = new int[N+1]; //정점의 수 +1 , 쉽게 계산하기 위함
		for(int i=1; i<=N; i++) {
			visited[i] = 0;
		}
	}
	
	public static void DFS(int v) {
		visited[v] = depth++;
		for(int i=0; i<list.get(v).size(); i++) {
			int nextV = list.get(v).get(i);
			if(visited[nextV] == 0) {
				DFS(nextV);
			}
		}
	}
	
}
