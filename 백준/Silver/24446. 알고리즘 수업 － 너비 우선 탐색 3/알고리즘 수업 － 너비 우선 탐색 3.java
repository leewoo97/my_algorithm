import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<int[]> queue = new LinkedList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];

		// 인접 리스트 만들기
		// 2차원 리스트
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

		for (int i = 0; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		// 인접 리스트 완성 , 이 위는 건들지 말것.
		queue.add(new int[] {R, 1});
		visited[R] = 1;

		while (!queue.isEmpty()) {
			int[] v = queue.poll();
			for (int i : list.get(v[0])) {
				if (visited[i] == 0) {
					queue.add(new int[] {i, v[1]+1});
					visited[i] = v[1]+1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<visited.length;i++) {
			sb.append(visited[i]-1);
			sb.append("\n");
		}
		System.out.println(sb);
		// BFS하려면 Q를 이용
	}
}
