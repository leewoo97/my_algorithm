import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> list;
	static Queue<Integer> queue;
	static int[] visited;
	static int visitedNum;
	static int N; //정점의 수
	static int M; //간선의 수
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		queue = new LinkedList<Integer>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		visitedNum = 1;
		listSet();
		visitedSet();
		BFS(R);
		printVisited();
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
		visited = new int[N+1];
	}
	
	public static void BFS(int v) {
		queue.add(v);
		visited[v] = visitedNum++;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			for(int i=0; i<list.get(v).size(); i++) {
				int nextV = list.get(v).get(i);
				if(visited[nextV]==0) {
					queue.add(nextV);
					visited[nextV] = visitedNum++;
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
