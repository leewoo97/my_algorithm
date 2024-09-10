import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; //정점 수
	static int M; //간선 수
	static List<List<Integer>> list;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); //시작 정점
		
		listSet();
		visitedSet();
		DFS(R,0);
		printVisited();
	}
	
	public static void listSet() throws IOException {
		list = new ArrayList<List<Integer>>();
		
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
		visited = new int[N+1];
		for(int i=1; i<=N; i++) {
			visited[i] = -1;
		}
	}
	
	public static void DFS(int v, int depth) {
		visited[v] = depth;
		
		for(int i=0; i<list.get(v).size(); i++) {
			int nextV = list.get(v).get(i);
			if(visited[nextV]==-1) {
				DFS(nextV, depth+1);
			}
		}
	}
	
	public static void printVisited() {
		for(int i=1; i<=N; i++) {
			System.out.println(visited[i]);
		}
	}
}
