import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Integer>> list;
	static Queue<Integer> queue;
	static int[] visited; //방문배열
	static int N; //정점 수
	static int M; //간선 수
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		listSet();
		visitedSet();
		queueSet();
		BFS(R, 0);
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
	}
	
	public static void visitedSet() {
		visited = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			visited[i] = -1;
		}
	}
	
	public static void queueSet() {
		queue = new LinkedList<Integer>();
	}
	
	public static void BFS(int v, int depth) {
		visited[v] = depth;
		queue.add(v);
		queue.add(depth);
		while(!queue.isEmpty()) {
			v = queue.poll();
			depth = queue.poll();
			for(int i=0; i<list.get(v).size(); i++) {
				int nextV = list.get(v).get(i);
				if(visited[nextV]==-1) {
					int nextDepth = depth+1;
					visited[nextV] = nextDepth;
					queue.add(nextV);
					queue.add(nextDepth);
				}
			}
		}
	}
	
	public static void printVisited() {
		for(int i=1; i<=N; i++) {
			System.out.println(visited[i]);
		}
	}
}
