import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st;
	static int N; //컴퓨터 전체 갯수
	static int M; //간선 갯수
	static List<List<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		listSet();
		visited = new boolean[N+1];
		DFS(1);
		
		System.out.println(virusResult());
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
	
	public static void DFS(int v) {
//		System.out.println(v);
		visited[v] = true;
		for(int i=0; i<list.get(v).size(); i++) {
			int nextV = list.get(v).get(i);
			if(!visited[nextV]) {
				DFS(nextV);
			}
		}
	}
	
	public static int virusResult() {
		int count = -1;
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) {
				count++;
			}
		}
		return count;
	}
}
