import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;
	static int Count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> list2 = new ArrayList<>();
			list.add(list2);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			list.get(temp).add(temp2);
			list.get(temp2).add(temp);
		}
		
		for(int i=0; i<=N;i++) {
			Collections.sort(list.get(i));
		}
		// 2차원 리스트 생성완료 //이 위로는 건들지 말것.
		// BFS이용

		q.add(R);
		visited[R] = ++Count;

		while (!q.isEmpty()) { 
			int v = q.poll(); 
//			System.out.println(v); 
			for (int i : list.get(v)) {
//				System.out.println(i);
				if (visited[i]==0) { //true
					q.add(i); 
					visited[i] = ++Count; 
				}
			}
		}
		for(int i=1;i<visited.length;i++) {
			System.out.println(visited[i]);
		}

	}

}
